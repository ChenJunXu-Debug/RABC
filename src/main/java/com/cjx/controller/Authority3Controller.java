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
@ResponseBody
@RequestMapping("authority3")
@Authority(roles={"subAdmin2"})
public class Authority3Controller {

    @RequestMapping("welcome1")
    public Resp welcome1() {
        return Resp.fail("welcome1", null);
    }

    @RequestMapping("welcome2")
    public Resp welcome2() {
        return Resp.ok("welcome2", null);
    }
}
