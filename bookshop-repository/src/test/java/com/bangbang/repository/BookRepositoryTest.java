package com.bangbang.repository;

import com.bangbang.BaseTest;
import com.bangbang.domain.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Optional;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 17:23
 */

public class BookRepositoryTest extends BaseTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PlatformTransactionManager platformTransactionManager;


    @Test
    public void createBook() {
        TransactionStatus transaction
                = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());

        Book book = new Book();
        book.setName("战争于和平");
        Book save = bookRepository.save(book);

        platformTransactionManager.commit(transaction);
    }


    @Test
    public void queryBook() {
        List<Book> all = bookRepository.findAll();
        System.out.println("all = " + all.size());
    }


    @Test
    public void queryBookById() {
        Optional<Book> byId = bookRepository.findById(1L);
        if (byId.isPresent()) {
            Book book = byId.get();
            System.out.println("book.getName() = " + book.getName());
        }
    }
}
