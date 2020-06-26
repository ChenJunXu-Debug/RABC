/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginController
 * Author:   ASUS
 * Date:     2020/6/20 18:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.controller;

import com.cjx.mapper.UserMapper;
import com.cjx.pojo.Menu;
import com.cjx.pojo.MenuNode;
import com.cjx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/20
 * @since 1.0.0
 */
@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest req) {
        return "redirect:/home";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest req) {
        User user = userMapper.login(username, password);
        if (user == null) {
            return "redirect:/";
        } else {
            List<Menu> menus = userMapper.findMenuByUid(user.getId());
            List<String> permissions = userMapper.findPermissionByUid(user.getId());
            List<String> roles = userMapper.findRolesByUid(user.getId());
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("menus", menus);
            req.getSession().setAttribute("permissions", permissions);
            req.getSession().setAttribute("roles", roles);
            return "redirect:/home";
        }
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login.jsp";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest req) {
        List<Menu> menus = (List<Menu>) req.getSession().getAttribute("menus");
        if (menus != null && menus.size() > 0) {
            List<MenuNode> trees = formatTree(menus);
            req.setAttribute("trees", trees);
        }
        return "/home.jsp";
    }

    private List<MenuNode> formatTree(List<Menu> menus) {
        //由节点组成的一棵树 一级菜单是根节点 一个根节点下面挂着一棵树
        List<MenuNode> trees = new ArrayList<>();
        List<MenuNode> nodes = new ArrayList<>(menus.size());
        //菜单转成节点
        for (Menu node : menus) {
            nodes.add(new MenuNode(node));
        }
        for (MenuNode node : nodes) {
            //一级菜单
            if (node.getPid() == null) {
                trees.add(node);
            }
            //其他菜单挂到父菜单下面
            else {
                //获取父菜单
                for (MenuNode parent : nodes) {
                    if (parent.getId() == node.getPid()) {
                        //获取父菜单的子菜单集合
                        List<MenuNode> childs = parent.getChilds();
                        //添加这个节点到子菜单集合
                        childs.add(node);
                    }
                }
            }
        }
        return trees;
    }
}
