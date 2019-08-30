package com.bangbang.dto;


import java.io.Serializable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 10:00
 */

public class BookInfo implements Serializable {

    private static final long serialVersionUID = 4722112887711967499L;

    public interface QueryBookList{};

    public interface QueryBookDetail extends QueryBookList{};

    private Long id;

    private String name;

    private String content;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
