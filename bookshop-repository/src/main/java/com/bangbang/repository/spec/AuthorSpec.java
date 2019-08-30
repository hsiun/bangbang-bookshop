package com.bangbang.repository.spec;

import com.bangbang.domain.Author;
import com.bangbang.dto.AuthorCondition;
import com.bangbang.repository.spec.support.QueryWraper;
import com.bangbang.repository.spec.support.ShopSimpleSpecification;
import org.apache.commons.lang.StringUtils;

import javax.persistence.criteria.Predicate;


/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-08-28 15:57
 */

public class AuthorSpec extends ShopSimpleSpecification<Author, AuthorCondition> {

    public AuthorSpec(AuthorCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Author> queryWraper) {

        if (StringUtils.isNotBlank(getCondition().getName())) {
            Predicate nameLike = createLikeCondition(queryWraper, "name", getCondition().getName());
            //Predicate emailLike = createLikeCondition(queryWraper, "email", getCondition().getName());
            queryWraper.addPredicate(queryWraper.getCb().or(nameLike));
        }
        addBetweenCondition(queryWraper, "age");
        addEqualsCondition(queryWraper, "sex");

    }
}
