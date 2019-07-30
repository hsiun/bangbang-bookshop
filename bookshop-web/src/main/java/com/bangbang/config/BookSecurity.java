package com.bangbang.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-23 19:53
 */


@Component("bookSecurity")
public class BookSecurity {


    public boolean check(Authentication authentication, HttpServletRequest httpServletRequest) {
        System.out.println("httpServletRequest = " + httpServletRequest.getRequestURI());

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            System.out.println(((UserDetails) principal).getAuthorities());

        }

        return true;
    }
}
