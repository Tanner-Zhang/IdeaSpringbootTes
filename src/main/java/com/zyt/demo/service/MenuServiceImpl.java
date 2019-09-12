package com.zyt.demo.service;

import com.zyt.demo.entity.SystemMenu;
import com.zyt.demo.service.impl.MenuService;
import com.zyt.demo.dao.MenuMapper;
import com.zyt.demo.entity.Children;
import com.zyt.demo.entity.Menu;
import com.zyt.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;



    //侧栏菜单查询
    @Override
    public Result systemMenuQuery() {

        Result result =new Result();

           //查询1级菜单
            List<SystemMenu> systemMenuList= this.mapper.systemMenuQuery();

            List<Map<String,Object>> systemlist=new ArrayList<>();
                for(SystemMenu systemMenu:systemMenuList) {
                //遍历1级菜单，通过id查询2级菜单
                   int systemMenu_id = systemMenu.getSystemMenu_id();
                      List<Menu> menuList = this.mapper.menuQuery(systemMenu_id);

                      List<Map<String, Object>> menulist = new ArrayList();
                      if (menuList==null){
                          systemMenu.setMenu(menulist);
                      }else {
                          for (Menu menu : menuList) {

                        //遍历2级菜单，通过id查询3级菜单
                        int menu_id = menu.getMenu_id();
                        List<Children> childrenList = this.mapper.chlidrenQuery(menu_id);
                        //循环添加
                        List<Map<String, Object>> childlist = new ArrayList();
                        if (childrenList == null) {
                            menu.setChildren(childlist);
                        } else {
                            for (Children children : childrenList) {
                                Map<String, Object> childmap = new ConcurrentHashMap<>();
                                childmap.put("title", children.getTitle());
                                childmap.put("href", children.getHref());
                                childmap.put("isCurrent", children.isCurrent());

                                childlist.add(childmap);
                                //将3级菜单所有内容放入menu
                                menu.setChildren(childlist);
                            }
                        }

                        Map<String, Object> menumap = new ConcurrentHashMap<>();
                        menumap.put("title", menu.getTitle());
                        menumap.put("icon", menu.getIcon());
                        menumap.put("isCurrent", menu.isCurrent());
                        if (menu.getChildren()==null){
                            List c =new ArrayList();
                        menumap.put("children",c);
                        }else {
                            menumap.put("children",menu.getChildren());
                        }
                        menulist.add(menumap);
                        //将2级菜单所有内容放入systemMenu
                        systemMenu.setMenu(menulist);
                    }
                      }

                    //除去systemMenu_id
                    Map<String, Object> systemMenuMap = new ConcurrentHashMap<>();
                    systemMenuMap.put("title", systemMenu.getTitle());
                    systemMenuMap.put("icon", systemMenu.getIcon());
                    systemMenuMap.put("isCurrent", systemMenu.isCurrent());

                    if (systemMenu.getMenu()==null){
                        List m = new ArrayList();
                        systemMenuMap.put("menu",m);
                    }else {
                        systemMenuMap.put("menu",systemMenu.getMenu());
                    }
                    systemlist.add(systemMenuMap);

            }
            result.setStatus(1);
            result.setMessage("菜单加载");
            result.setData(systemlist);
            return result;
    }



    //菜单配置 树菜单查询
    @Override
    public List treeMenuQuery() {


            List rows = new ArrayList();

            //查询1级菜单
            List<SystemMenu> systemMenuList=this.mapper.systemMenuQuery();
            for (SystemMenu systemMenu:systemMenuList){
                int systemMenu_id=systemMenu.getSystemMenu_id();
                String systemMenu_name=systemMenu.getTitle();
                String systemMenu_icon=systemMenu.getIcon();

                Map <String,Object> treeMenuMap =new ConcurrentHashMap<>();
                treeMenuMap.put("id",systemMenu_id);
                treeMenuMap.put("name",systemMenu_name);
                treeMenuMap.put("iconname",systemMenu_icon);
                treeMenuMap.put("level",1);
                rows.add(treeMenuMap);


                List<Menu> menuList=this.mapper.menuQuery(systemMenu_id);
                for (Menu menu:menuList){
                    int menu_id=menu.getMenu_id();
                    String menu_name=menu.getTitle();
                    String menu_icon=menu.getIcon();


                    Map <String,Object> treeMenuMap2 =new ConcurrentHashMap<>();
                    treeMenuMap2.put("pname",systemMenu_name);
                    treeMenuMap2.put("id",menu_id);
                    treeMenuMap2.put("name",menu_name);
                    treeMenuMap2.put("_parentId",systemMenu_id);
                    treeMenuMap2.put("level",2);
                    treeMenuMap2.put("iconname",menu_icon);
                    rows.add(treeMenuMap2);


                    List<Children> childrenList=this.mapper.chlidrenQuery(menu_id);
                    for (Children children : childrenList){
                        int children_id = children.getChildren_id();
                        String child_name = children.getTitle();
                        String href = children.getHref();

                        Map <String,Object>  treeMenuMap3 = new ConcurrentHashMap<>();
                        treeMenuMap3.put("pname",menu_name);
                        treeMenuMap3.put("id",children_id);
                        treeMenuMap3.put("name",child_name);
                        treeMenuMap3.put("href",href);
                        treeMenuMap3.put("level",3);
                        treeMenuMap3.put("_parentId",menu_id);

                        rows.add(treeMenuMap3);
                    }
                }

            }

            return rows;

    }






    //新增基本菜单
    //1、2级菜单 title(标题) icon(菜单图片) isCurrent(是否直接加载)
    //3级菜单 title  href(3级菜单地址)  isCurrent

    @Transactional
    @Override
    public Result MenuCreate(String title1,String icon1,boolean isCurrent1,
                             String title2,String icon2,boolean isCurrent2,
                             String title3,String href, boolean isCurrent3
                             ) {
        Result result = new Result();

        try{
            //新增1级菜单
            this.mapper.systemMenuCreate(title1,icon1,isCurrent1);

            //新增2级菜单
            this.mapper.menuCreate(title2,icon2,isCurrent2);

            //新增3级菜单
            this.mapper.childrenCreate(title3,href,isCurrent3);


            //查询各级菜单id
            int systemMenu_id=this.mapper.querySystemMenu_idByTitle(title1);
            int menu_id=this.mapper.queryMenu_idByTitle(title2);
            int children_id=this.mapper.queryChildren_idByTitle(title3);

            //sid_mid表
            this.mapper.smAdd(systemMenu_id,menu_id);

            //mid_cid表
            this.mapper.mcAdd(menu_id,children_id);

            result.setMessage("菜单添加成功");
            result.setStatus(1);

        }catch(Exception e){

            result.setMessage("添加失败："+e.getMessage());
            result.setStatus(0);

        }


        return result;


    }


    //菜单添加
    @Override
    public Result MenuCreate2(int level, String title, String ptitle, String icon, boolean isCurrent,String href2) {

        Result result = new Result();

        try {
            if (level==1){
                this.mapper.systemMenuCreate(title,icon,isCurrent);
                result.setStatus(1);
                result.setMessage("1级菜单添加成功");
            }else if (level==2){
                if (ptitle!=null){
                    this.mapper.menuCreate(title,icon,isCurrent);
                    int systemMenu_id=this.mapper.querySystemMenu_idByTitle(ptitle);
                    int menu_id=this.mapper.queryMenu_idByTitle(title);
                    this.mapper.smAdd(systemMenu_id,menu_id);
                    result.setStatus(1);
                    result.setMessage("2级菜单添加成功");
                }else {
                    result.setStatus(0);
                    result.setMessage("2、3级菜单父菜单名称不能为空");
                }
            }else if(level==3){
                if (ptitle!=null&&href2!=null) {
                    this.mapper.childrenCreate(title, href2, isCurrent);
                    int menu_id = this.mapper.queryMenu_idByTitle(ptitle);
                    int children_id = this.mapper.queryChildren_idByTitle(title);
                    this.mapper.mcAdd(menu_id, children_id);
                    result.setStatus(1);
                    result.setMessage("3级菜单添加成功");
                }else {
                    result.setStatus(0);
                    result.setMessage("2、3级菜单父菜单名称不能为空，且3级菜单地址不能为空");
                }
            }

        }catch (Exception e){
            result.setMessage("添加失败："+e.getMessage());
            result.setStatus(0);
        }

        return result;
    }


}
