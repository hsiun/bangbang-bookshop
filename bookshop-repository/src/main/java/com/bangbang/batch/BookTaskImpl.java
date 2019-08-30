package com.bangbang.batch;

import org.springframework.stereotype.Component;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-08-30 11:30
 */


@Component
public class BookTaskImpl implements BookTask {


    @Override
    public void doTask() {
        System.out.println("I am schedued ...");
    }
}
