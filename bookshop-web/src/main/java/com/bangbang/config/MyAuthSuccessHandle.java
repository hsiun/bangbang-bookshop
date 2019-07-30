package com.bangbang.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-22 23:04
 */

@Component
public class MyAuthSuccessHandle extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        System.out.println(authentication.getPrincipal());

        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}
