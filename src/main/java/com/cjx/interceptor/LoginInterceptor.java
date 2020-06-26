/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginInterceptor
 * Author:   ASUS
 * Date:     2020/6/21 12:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.interceptor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/21
 * @since 1.0.0
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjx.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (!uri.equals("/login") && !uri.equals("/toLogin")) {
            User user = (User)request.getSession().getAttribute("user");
            if (user == null) {
                request.getRequestDispatcher("/toLogin").forward(request, response);
                return false;
            }
        }
        return true;
    }

}

