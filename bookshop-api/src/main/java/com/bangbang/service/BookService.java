package com.bangbang.service;

import com.bangbang.dto.BookCondition;
import com.bangbang.dto.BookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-23 08:50
 */

public interface BookService {

    /**
     * 通过Id获取图书信息
     * @param id
     * @return
     */
    BookInfo getBookInfo(Long id);


    /**
     * 分页查询图书信息
     * @param bookCondition
     * @param pageable
     * @return
     */
    Page<BookInfo> query(BookCondition bookCondition, Pageable pageable);


    /**
     * 创建
     * @param bookInfo
     * @return
     */
    BookInfo create(BookInfo bookInfo);


    /**
     * 更新
     * @param bookInfo
     * @return
     */
    BookInfo update(BookInfo bookInfo);


    /**
     * 删除
     * @param id
     */
    void delete(Long id);


    /**
     * 任务调度测试
     */
    void task() throws Exception;

}
