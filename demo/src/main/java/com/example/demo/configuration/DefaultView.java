package com.example.demo.configuration;

import com.example.demo.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
* @Description:    springboot 配置类
* @Author:         zgf
* @CreateDate:     2019/5/29 21:46
* @UpdateUser:     zgf
* @UpdateDate:     2019/5/29 21:46
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
public class DefaultView  extends WebMvcConfigurerAdapter {

    @Autowired

    private LoginHandlerInterceptor loginInterceptor;


    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这条语句的作用是对所有路径应用拦截器，除了 /index.html 以及css、js、images目录下的文件,因为static是静态资源直接访问static目录的文件 。
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index.html","/css/**","/js/**","/images/**");
        super.addInterceptors(registry);    //较新

    }
}

