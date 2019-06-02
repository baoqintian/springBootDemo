package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
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

//
//    @Override    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/hello").setViewName("index");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }
}

