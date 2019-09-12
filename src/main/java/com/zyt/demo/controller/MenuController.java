package com.zyt.demo.controller;

import com.zyt.demo.service.impl.MenuService;
import com.zyt.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;


    //菜单查询
    @RequestMapping(value = "/menu",method = RequestMethod.POST)
    @ResponseBody
    public Result menu(){

        Result result=this.menuService.systemMenuQuery();

        return result;
    }

    //菜单配置
    @RequestMapping(value = "/treeMenuQuery" ,method = RequestMethod.POST)
    @ResponseBody
    public List treeMenuQuery(){
        List rows=this.menuService.treeMenuQuery();
        return rows;
    }


    //新建基本菜单
    //1、2级菜单 title(标题) icon(菜单图片) isCurrent(是否直接加载)
    //3级菜单 title  href(3级菜单地址)  isCurrent
    @RequestMapping(value = "/MenuCreate",method = RequestMethod.POST)
    @ResponseBody
    public  Result MenuCreate(String title1,String icon1,boolean isCurrent1,
                              String title2,String icon2,boolean isCurrent2,
                              String title3,String href, boolean isCurrent3){

        Result result=this.menuService.MenuCreate(title1,icon1,isCurrent1,
                title2,icon2,isCurrent2,title3,href,isCurrent3);
        return result;

    }


    //新增菜单
    @RequestMapping(value = "/MenuCreate2",method = RequestMethod.POST)
    @ResponseBody
    public Result MenuCreate2(int level,String title,String ptitle,String icon,boolean isCurrent,String href2){

        Result result =this.menuService.MenuCreate2(level,title,ptitle,icon,isCurrent,href2);

        return result;
    }

}
