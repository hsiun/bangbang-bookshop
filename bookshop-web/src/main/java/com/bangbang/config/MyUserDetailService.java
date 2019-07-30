package com.bangbang.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-22 22:29
 */


@Component
public class MyUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("admin", "xxxx");

        if (StringUtils.equals(username, "zhangsan")) {
            return new User("zhangsan",
                    new BCryptPasswordEncoder().encode("123456"),
                    authorityList);
        }
        return null;
    }
}
