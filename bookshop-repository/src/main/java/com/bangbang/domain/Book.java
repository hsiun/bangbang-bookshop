package com.bangbang.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 17:37
 */


@Entity
public class Book extends CommonAttribute {

    @Id
    @GeneratedValue
    private long id;


    private String name;


    @ManyToOne
    private Category category;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
