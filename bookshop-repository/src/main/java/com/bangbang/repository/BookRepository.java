package com.bangbang.repository;


import com.bangbang.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 18:14
 */


public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
