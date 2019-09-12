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
public class SystemMenu implements Serializable {

    private static final long serialVersionUID = -2057644187690957717L;


    private int systemMenu_id;
    private String title;
    private String icon;
    private boolean isCurrent;
    private List<Map<String,Object>> menu;

    public int getSystemMenu_id() {
        return systemMenu_id;
    }

    public void setSystemMenu_id(int systemMenu_id) {
        this.systemMenu_id = systemMenu_id;
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

    public List<Map<String, Object>> getMenu() {
        return menu;
    }

    public void setMenu(List<Map<String, Object>> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
                "systemMenu_id=" + systemMenu_id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", isCurrent=" + isCurrent +
                ", menu=" + menu +
                '}';
    }
}