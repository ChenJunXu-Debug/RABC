/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WebConfigurer
 * Author:   ASUS
 * Date:     2020/6/21 12:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.config;

import com.cjx.interceptor.AuthorityInterceptor;
import com.cjx.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/21
 * @since 1.0.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuthorityInterceptor())
                .addPathPatterns("/authority1/**", "/authority2/**","/authority3/**");
    }
}
