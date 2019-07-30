package com.bangbang.service;

import com.bangbang.dto.BookInfo;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-23 08:50
 */

public interface BookService {

    BookInfo getBookInfo(Long id);
}
