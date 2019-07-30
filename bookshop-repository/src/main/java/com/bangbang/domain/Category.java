package com.bangbang.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 17:38
 */


@Entity
public class Category extends CommonAttribute {

    @Id
    @GeneratedValue
    private long id;


    private String name;


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
}
