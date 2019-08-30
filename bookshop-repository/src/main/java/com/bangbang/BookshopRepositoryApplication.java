package com.bangbang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 09:50
 */

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class BookshopRepositoryApplication
{
    public static void main( String[] args ) throws Exception {
        SpringApplication.run(BookshopRepositoryApplication.class, args);
    }

}
