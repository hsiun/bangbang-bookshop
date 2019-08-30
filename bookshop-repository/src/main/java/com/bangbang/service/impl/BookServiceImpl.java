package com.bangbang.service.impl;

import com.bangbang.aspect.ServiceLog;
import com.bangbang.domain.Book;
import com.bangbang.dto.BookCondition;
import com.bangbang.dto.BookInfo;
import com.bangbang.repository.BookRepository;
import com.bangbang.repository.spec.BookSpec;
import com.bangbang.service.BookService;
import com.bangbang.support.AbstractDomain2InfoConverter;
import com.bangbang.support.QueryResultConverter;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-23 08:51
 */

@Service(version = "1.0.0")
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private JobLauncher jobLauncher;


    @Autowired
    private Job job;



    @Override
    @ServiceLog
    @Cacheable("books")
    //@Transactional
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


    @Override
    public Page<BookInfo> query(BookCondition bookCondition, Pageable pageable) {
        Page<Book> all = bookRepository.findAll(new BookSpec(bookCondition), pageable);

        return QueryResultConverter.convert(all, pageable, new AbstractDomain2InfoConverter<Book, BookInfo>() {
            @Override
            protected void doConvert(Book domain, BookInfo info) throws Exception {
                info.setContent("xxx");
            }
        });
    }

    @Override
    public BookInfo create(BookInfo bookInfo) {

        Book book = new Book();
        book.setName(bookInfo.getName());
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        Book saveBook = bookRepository.save(book);
        bookInfo.setId(saveBook.getId());
        return bookInfo;
    }

    @Override
    public BookInfo update(BookInfo bookInfo) {

        Book book = bookRepository.getOne(bookInfo.getId());
        book.setId(bookInfo.getId());
        book.setName(bookInfo.getName());
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());

        bookRepository.save(book);
        return null;
    }

    @Override
    public void delete(Long id) {

        Book book = bookRepository.getOne(id);
        bookRepository.delete(book);

    }


    @Override
    @Scheduled(cron = "0/3 * * * * *")
    public void task() throws Exception {
        Map<String, JobParameter> para = new HashMap<>(1);
        para.put("startTime", new JobParameter(new Date()));
        jobLauncher.run(job, new JobParameters(para));

    }
}
