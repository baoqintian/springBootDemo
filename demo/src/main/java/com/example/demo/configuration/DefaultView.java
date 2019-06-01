package com.example.demo.configuration;


import com.example.demo.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
public class DefaultView extends WebMvcConfigurerAdapter {

    /**
     * 默认访问登入页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/hello");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/hello");
    }

}

