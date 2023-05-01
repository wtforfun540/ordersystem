package com.shoom.ordersystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangtao
 * @date 2023/4/30 20:21
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//项目中的所有接口都支持跨域
                .allowedOrigins("*") //所有源地址都可以访问
                .allowCredentials(true) //将凭证（如Cookies）和跨域请求一起发送到服务器
                .allowedMethods("*") //所有方法
                .maxAge(3600);
    }
}
