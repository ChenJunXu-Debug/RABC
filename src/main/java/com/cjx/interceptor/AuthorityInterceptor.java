/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AuthorityInterceptor
 * Author:   ASUS
 * Date:     2020/6/25 10:09
 * Description: 权限拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.interceptor;

import com.alibaba.fastjson.JSON;
import com.cjx.Annptation.Authority;
import com.cjx.pojo.Resp;
import com.cjx.pojo.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限拦截器〉
 *
 * @author ASUS
 * @create 2020/6/25
 * @since 1.0.0
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> clz = method.getDeclaringClass();
        List<String> roleList = (List<String>)request.getSession().getAttribute("roles");
        User user = (User)request.getSession().getAttribute("user");
        //类注解
        Authority classAnnotation = clz.getAnnotation(Authority.class);
        if (classAnnotation != null) {
            String[] roles = classAnnotation.roles();
            if (hasAuthority(roleList, roles)) {
                return true;
            }
        }
        //方法注解
        Authority methodAnnotation = method.getAnnotation(Authority.class);
        if (methodAnnotation != null) {
            String[] roles = methodAnnotation.roles();
            if (hasAuthority(roleList, roles)) {
                return true;
            }
        }
        //获取返回json数据的注解
        RestController restController = clz.getAnnotation(RestController.class);
        ResponseBody responseBody1 = clz.getAnnotation(ResponseBody.class);
        ResponseBody responseBody2 = method.getAnnotation(ResponseBody.class);
        //有就返回json数据
        if (restController != null || responseBody1 != null || responseBody2 != null){
            response.getOutputStream().print(
                    JSON.toJSONString(Resp.fail("账号" + user.getUsername() + "无权限", null)));
        }
        //跳转到提示页面
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/noAuthority.jsp").forward(request, response);
        }
        return false;
    }

    /**
     * 是否有权限
     * @param roleList 用户角色集合
     * @param roles 注解允许访问角色集合
     * @return
     */
    private boolean hasAuthority(List<String> roleList, String[] roles) {
        if (roleList == null || roleList.size() == 0) {
            return false;
        }
        if (roles == null || roles.length == 0) {
            return false;
        }
        //其中一个角色能访问 这个账号就能访问
        for (String role:roleList) {
            for (String permitRole:roles) {
                if (role != null && role.equals(permitRole)) {
                    return true;
                }
            }
        }
        return false;
    }
}
