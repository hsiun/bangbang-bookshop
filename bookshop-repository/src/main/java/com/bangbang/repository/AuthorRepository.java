package com.bangbang.repository;


import com.bangbang.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 18:19
 */

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
