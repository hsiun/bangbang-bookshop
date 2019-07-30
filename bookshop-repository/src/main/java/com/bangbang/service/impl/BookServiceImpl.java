package com.bangbang.service.impl;

import com.bangbang.domain.Book;
import com.bangbang.dto.BookInfo;
import com.bangbang.repository.BookRepository;
import com.bangbang.service.BookService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-23 08:51
 */

@Service(version = "1.0.0")
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookInfo getBookInfo(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        Book book = new Book();

        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }

        System.out.println("book.toString() = " + book.getName());
        book.setId(1);
        book.setName("aaa");
        BookInfo info = new BookInfo();

        info.setName(book.getName());

        return info;
    }
}
