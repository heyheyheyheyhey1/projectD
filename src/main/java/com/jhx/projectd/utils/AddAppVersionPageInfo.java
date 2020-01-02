package com.jhx.projectd.utils;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class AddAppVersionPageInfo {
    private Integer id;
    private Integer appId;
    private String  versionNo;
    private BigDecimal versionSize;
    private String versionInfo;
    private Integer publishStatus;
    private  MultipartFile a_downloadLink;

    @Override
    public String toString() {
        return "AddAppVersionPageInfo{" +
                "appId=" + appId +
                ", versionNo='" + versionNo + '\'' +
                ", versionSize=" + versionSize +
                ", versionInfo='" + versionInfo + '\'' +
                ", publishStatus=" + publishStatus +
                ", a_downloadLink=" + a_downloadLink +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

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
