package com.bangbang.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 08:11
 */


@Component
public class TimerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        request.setAttribute("startTime", System.currentTimeMillis());
        System.out.println("这里是preHandle的打印");
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println(System.currentTimeMillis() - (long) request.getAttribute("startTime"));
        System.out.println("这里是postHandle的打印");

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable Exception ex) throws Exception {
        System.out.println(System.currentTimeMillis() - (long) request.getAttribute("startTime"));
        System.out.println("这里是afterCompletion的打印");
        System.out.println(ex);

    }


}
