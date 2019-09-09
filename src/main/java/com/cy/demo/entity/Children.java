/**
  * Copyright 2019 bejson.com 
  */
package com.cy.demo.entity;

import java.io.Serializable;

/**
 * Auto-generated: 2019-08-05 14:57:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Children implements Serializable {

    private static final long serialVersionUID = -8196860904346894647L;
    private int children_id;
    private String title;
    private String href;
    private boolean isCurrent;


    public int getChildren_id() {
        return children_id;
    }

    public void setChildren_id(int children_id) {
        this.children_id = children_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    @Override
    public String toString() {
        return "Children{" +
                "children_id=" + children_id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", isCurrent=" + isCurrent +
                '}';
    }
}