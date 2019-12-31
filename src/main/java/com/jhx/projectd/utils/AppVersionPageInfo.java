package com.jhx.projectd.utils;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class AppVersionPageInfo {
    private Integer appId;
    private String  versionNo;
    private BigDecimal versionSize;
    private Integer satusId;
    private String versionInfo;
    private  MultipartFile a_downloadLink;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public BigDecimal getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(BigDecimal versionSize) {
        this.versionSize = versionSize;
    }

    public Integer getSatusId() {
        return satusId;
    }

    public void setSatusId(Integer satusId) {
        this.satusId = satusId;
    }

    public String getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }

    public MultipartFile getA_downloadLink() {
        return a_downloadLink;
    }

    public void setA_downloadLink(MultipartFile a_downloadLink) {
        this.a_downloadLink = a_downloadLink;
    }
}
