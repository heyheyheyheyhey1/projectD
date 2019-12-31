package com.jhx.projectd.utils;

import org.springframework.data.relational.core.sql.In;

public class UnivsJson {
    private String status;
    private String info;
    private Integer errorCode;

    public String getStatus() {
        return status;
    }

    public UnivsJson setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public UnivsJson setInfo(String info) {
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public UnivsJson setErrorCode(Integer errorCode) {
        return this;
    }
}
