package com.bangbang.dto;

import java.io.Serializable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-08-28 15:54
 */

public class AuthorCondition implements Serializable {

    private static final long serialVersionUID = -3146472220861528322L;

    private String name;

    private Integer age;

    private Integer ageTo;

    private Sex sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
