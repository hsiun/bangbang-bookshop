package com.bangbang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-17 09:39
 */



@RestController
public class HelloController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }
}
