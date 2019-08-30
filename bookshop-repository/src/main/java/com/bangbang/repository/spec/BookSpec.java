package com.bangbang.repository.spec;

import com.bangbang.domain.Book;
import com.bangbang.dto.BookCondition;
import com.bangbang.repository.spec.support.QueryWraper;
import com.bangbang.repository.spec.support.ShopSimpleSpecification;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-08-28 16:36
 */

public class BookSpec extends ShopSimpleSpecification<Book, BookCondition> {

    public BookSpec(BookCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Book> queryWraper) {

        addLikeCondition(queryWraper, "name");

    }
}
