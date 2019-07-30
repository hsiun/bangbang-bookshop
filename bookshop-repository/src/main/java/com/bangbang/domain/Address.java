package com.bangbang.domain;

import javax.persistence.Embeddable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 18:11
 */


@Embeddable
public class Address {

    /** 省 */
    private String state;

    /** 市 */
    private String city;

    /** 街 */
    private String stree;

    /** 详细地址 */
    private String detail;

    /** 邮编 */
    private String zipcode;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStree() {
        return stree;
    }

    public void setStree(String stree) {
        this.stree = stree;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
