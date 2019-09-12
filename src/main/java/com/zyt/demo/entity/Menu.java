/**
  * Copyright 2019 bejson.com 
  */
package com.zyt.demo.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Auto-generated: 2019-08-05 14:57:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = -6228572468493512415L;
    private int menu_id;
    private String title;
    private String icon;
    private boolean isCurrent;
    private List<Map<String,Object>> children;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public List<Map<String, Object>> getChildren() {
        return children;
    }

    public void setChildren(List<Map<String, Object>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", isCurrent=" + isCurrent +
                ", children=" + children +
                '}';
    }
}