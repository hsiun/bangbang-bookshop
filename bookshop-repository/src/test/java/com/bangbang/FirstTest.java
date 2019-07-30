package com.bangbang;

import org.junit.Test;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 15:57
 */


public class FirstTest extends BaseTest {


    //引入jpa后会自动连接数据库，所以这里就是测试数据库连接
    @Test
    public void hello() {
        System.out.println("hello !!");

    }
}
