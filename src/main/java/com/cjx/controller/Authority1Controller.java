/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Authority1Controller
 * Author:   ASUS
 * Date:     2020/6/25 11:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.controller;

import com.cjx.Annptation.Authority;
import com.cjx.pojo.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("authority1")
@Authority(roles={"subAdmin1"})
public class Authority1Controller {

    @RequestMapping("welcome1")
    public String welcome1(HttpServletRequest req) {
        req.setAttribute("page", "a1");
        return "welcome.jsp";
    }

    @RequestMapping("welcome2")
    @ResponseBody
    public Resp welcome2() {
        return Resp.ok("welcome", null);
    }
}
