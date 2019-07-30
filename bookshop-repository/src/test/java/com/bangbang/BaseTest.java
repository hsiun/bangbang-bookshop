package com.bangbang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 09:50
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookshopRepositoryApplication.class)
@Transactional
public class BaseTest {

    @Test
    public void test() {}
}