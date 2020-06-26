/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Menu
 * Author:   ASUS
 * Date:     2020/6/21 13:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/21
 * @since 1.0.0
 */
public class MenuNode {
    private int id;
    private String name;
    private Integer pid;
    private List<MenuNode> childs;

    public MenuNode(){};

    public MenuNode(Menu menu){
        this.id = menu.getId();
        this.name = menu.getName();
        this.pid = menu.getPid();
        this.childs = new ArrayList<>();
    };

    public List<MenuNode> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuNode> childs) {
        this.childs = childs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
