package com.bangbang.service.impl;

import com.bangbang.BaseTest;
import com.bangbang.dto.BookInfo;
import com.bangbang.repository.BookRepository;
import com.bangbang.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-08-28 15:33
 */

public class BookServiceTest extends BaseTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;


    @Test
    public void whenCreateSuccess() {
        long count = bookRepository.count();

        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("xxxxx");

        BookInfo createInfo = bookService.create(bookInfo);

        Assert.assertEquals(count + 1, bookRepository.count());

    }
}
