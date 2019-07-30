package com.bangbang.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-15 17:31
 */

@MappedSuperclass
public class CommonAttribute {

    @GeneratedValue
    @Id
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
