package com.bangbang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 09:52
 */


@SpringBootApplication
@EnableSwagger2
@EnableJdbcHttpSession
public class BookshopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshopWebApplication.class, args);

    }
}
