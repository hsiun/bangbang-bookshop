package com.bangbang.controller;

import com.bangbang.dto.BookCondition;
import com.bangbang.dto.BookInfo;
import com.bangbang.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 09:59
 */

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private BookService bookService;


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public BookInfo update(@RequestBody BookInfo bookInfo) {

        return bookService.update(bookInfo);
    }

    @PostMapping
    public BookInfo create(@Valid @RequestBody BookInfo bookInfo, BindingResult result) {

        return bookService.create(bookInfo);
    }


    @GetMapping
    //@JsonView(BookInfo.QueryBookList.class)
    @ApiOperation("查询图书详情")
    public List<BookInfo> queryBook(@ApiParam("图书名字") @RequestParam(name = "name", defaultValue = "aaa") String bookname,
                                    @CookieValue String token, @RequestHeader String header) {
        System.out.println("token = " + token);
        System.out.println("header = " + header);
        System.out.println("name = " + bookname);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("测试");
        List<BookInfo> bookList = new ArrayList(3);
        bookList.add(bookInfo);
        bookList.add(new BookInfo());
        bookList.add(new BookInfo());

        return bookList;
    }


    @GetMapping("/condition")
    public List<BookInfo> queryBookByCondition(BookCondition condition, Pageable pageable) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            System.out.println(authentication.getPrincipal().toString());
        }


        System.out.println("condition.getCategory() = " + condition.getCategory());
        System.out.println("condition.getName() = " + condition.getName());

        System.out.println("pageable = " + pageable.getPageNumber());
        System.out.println("pageable.getPageSize() = " + pageable.getPageSize());


        List<BookInfo> bookList = new ArrayList(3);
        bookList.add(new BookInfo());
        bookList.add(new BookInfo());
        bookList.add(new BookInfo());

        return bookList;
    }



    @GetMapping("/{id:\\d}")
    //@JsonView(BookInfo.QueryBookDetail.class)
//    public Callable<BookInfo> queryBookinfo(@PathVariable String id) {
      public BookInfo queryBookinfo(@PathVariable String id) {
        long longId = Long.parseLong(id);
        return bookService.getBookInfo(longId);
//        BookInfo bookInfo = new BookInfo();
//        bookInfo.setName("aaa");
//        bookInfo.setContent("bbb");
//        return bookInfo;

//
//        Callable<BookInfo> result = () -> {
//            Thread.sleep(1000);
//            BookInfo bookInfo = new BookInfo();
//            bookInfo.setName("aaa");
//
//            return bookInfo;
//        };

        //throw new RuntimeException("test");

//        System.out.println("id = " + id);
//
//        BookInfo bookInfo = new BookInfo();
//        bookInfo.setName("aaa");
//        return bookInfo;
    }
}
