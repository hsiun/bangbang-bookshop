package com.bangbang.config;

import com.bangbang.interceptor.TimerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 08:24
 */


//@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    TimerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor);
    }
}
