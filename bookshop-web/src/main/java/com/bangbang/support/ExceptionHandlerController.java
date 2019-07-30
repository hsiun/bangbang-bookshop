package com.bangbang.support;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 07:54
 */


@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler
    @ResponseStatus
    public Map<String, Object> handleException(RuntimeException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", "fauil");
        map.put("message", ex.getMessage());

        return map;
    }
}
