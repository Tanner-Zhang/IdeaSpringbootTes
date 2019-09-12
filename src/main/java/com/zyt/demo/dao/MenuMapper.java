package com.zyt.demo.dao;

import com.zyt.demo.entity.Children;
import com.zyt.demo.entity.Menu;
import com.zyt.demo.entity.SystemMenu;
import com.zyt.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    //登录
    public User login(String name);
    User findAll();
    //1级菜单查询
    public List<SystemMenu> systemMenuQuery();

    //当前1级菜单的2级菜单查询
    public List<Menu> menuQuery(int systemMenu_id);

    //当前1级菜单的3级菜单查询
    public List<Children> chlidrenQuery(int menu_id);

    //新增1级菜单
    public void systemMenuCreate(String title1,String icon1,boolean isCurrent1);

    //新增2级菜单
    public void menuCreate(String title2,String icon2,boolean isCurrent2);

    //新增3级菜单
    public void childrenCreate(String title3,String href,boolean isCurrent3);

    //通过title1查询1级菜单id
    public int querySystemMenu_idByTitle(String title1);

    //通过title2查询2级菜单id
    public int queryMenu_idByTitle(String title2);

    //通过title3查询3级菜单id
    public int queryChildren_idByTitle(String title3);

    //新增sid_mid关系
    public  void  smAdd(int systemMenu_id,int menu_id);

    //新增mid_cid关系
    public void  mcAdd(int menu_id,int children_id);


}
