package com.bangbang.dto;

import java.io.Serializable;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 19:59
 */

public class FileInfo implements Serializable {

    private static final long serialVersionUID = -2076493369016128411L;
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
