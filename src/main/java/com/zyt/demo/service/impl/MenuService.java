package com.zyt.demo.service.impl;

import com.zyt.demo.util.Result;

import java.util.List;

public interface MenuService {

    //1级菜单查询
    public Result systemMenuQuery();


    //菜单配置 树菜单查询
    public List treeMenuQuery();


    //创建基本菜单
    public Result MenuCreate(String title1,String icon1,boolean isCurrent1,
                             String title2,String icon2,boolean isCurrent2,
                             String title3,String href, boolean isCurrent3);


    //创建菜单
    public Result MenuCreate2(int level,String title,String ptitle,String icon,boolean isCurrent,String href2);

}
