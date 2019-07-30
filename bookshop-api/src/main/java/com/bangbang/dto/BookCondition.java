package com.bangbang.dto;


import java.io.Serializable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-17 20:33
 */

public class BookCondition implements Serializable {

    private static final long serialVersionUID = 1466530508305750879L;

    private String name;

    private String category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
