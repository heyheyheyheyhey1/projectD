package com.jhx.projectd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppVersion implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.appId
     *
     * @mbg.generated
     */
    private Integer appid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.versionNo
     *
     * @mbg.generated
     */
    private String versionno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.publishStatus
     *
     * @mbg.generated
     */
    private Integer publishstatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.downloadLink
     *
     * @mbg.generated
     */
    private String downloadlink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.versionSize
     *
     * @mbg.generated
     */
    private BigDecimal versionsize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.uodate_time
     *
     * @mbg.generated
     */
    private Date uodateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.apkLocPath
     *
     * @mbg.generated
     */
    private String apklocpath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.apkFileName
     *
     * @mbg.generated
     */
    private String apkfilename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_version.versionInfo
     *
     * @mbg.generated
     */
    private String versioninfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.id
     *
     * @return the value of app_version.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.id
     *
     * @param id the value for app_version.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.appId
     *
     * @return the value of app_version.appId
     *
     * @mbg.generated
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.appId
     *
     * @param appid the value for app_version.appId
     *
     * @mbg.generated
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.versionNo
     *
     * @return the value of app_version.versionNo
     *
     * @mbg.generated
     */
    public String getVersionno() {
        return versionno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.versionNo
     *
     * @param versionno the value for app_version.versionNo
     *
     * @mbg.generated
     */
    public void setVersionno(String versionno) {
        this.versionno = versionno == null ? null : versionno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.publishStatus
     *
     * @return the value of app_version.publishStatus
     *
     * @mbg.generated
     */
    public Integer getPublishstatus() {
        return publishstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.publishStatus
     *
     * @param publishstatus the value for app_version.publishStatus
     *
     * @mbg.generated
     */
    public void setPublishstatus(Integer publishstatus) {
        this.publishstatus = publishstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.downloadLink
     *
     * @return the value of app_version.downloadLink
     *
     * @mbg.generated
     */
    public String getDownloadlink() {
        return downloadlink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.downloadLink
     *
     * @param downloadlink the value for app_version.downloadLink
     *
     * @mbg.generated
     */
    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink == null ? null : downloadlink.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.versionSize
     *
     * @return the value of app_version.versionSize
     *
     * @mbg.generated
     */
    public BigDecimal getVersionsize() {
        return versionsize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.versionSize
     *
     * @param versionsize the value for app_version.versionSize
     *
     * @mbg.generated
     */
    public void setVersionsize(BigDecimal versionsize) {
        this.versionsize = versionsize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.create_time
     *
     * @return the value of app_version.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.create_time
     *
     * @param createTime the value for app_version.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.uodate_time
     *
     * @return the value of app_version.uodate_time
     *
     * @mbg.generated
     */
    public Date getUodateTime() {
        return uodateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.uodate_time
     *
     * @param uodateTime the value for app_version.uodate_time
     *
     * @mbg.generated
     */
    public void setUodateTime(Date uodateTime) {
        this.uodateTime = uodateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.apkLocPath
     *
     * @return the value of app_version.apkLocPath
     *
     * @mbg.generated
     */
    public String getApklocpath() {
        return apklocpath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.apkLocPath
     *
     * @param apklocpath the value for app_version.apkLocPath
     *
     * @mbg.generated
     */
    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath == null ? null : apklocpath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.apkFileName
     *
     * @return the value of app_version.apkFileName
     *
     * @mbg.generated
     */
    public String getApkfilename() {
        return apkfilename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.apkFileName
     *
     * @param apkfilename the value for app_version.apkFileName
     *
     * @mbg.generated
     */
    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename == null ? null : apkfilename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_version.versionInfo
     *
     * @return the value of app_version.versionInfo
     *
     * @mbg.generated
     */
    public String getVersioninfo() {
        return versioninfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_version.versionInfo
     *
     * @param versioninfo the value for app_version.versionInfo
     *
     * @mbg.generated
     */
    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo == null ? null : versioninfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", versionno=").append(versionno);
        sb.append(", publishstatus=").append(publishstatus);
        sb.append(", downloadlink=").append(downloadlink);
        sb.append(", versionsize=").append(versionsize);
        sb.append(", createTime=").append(createTime);
        sb.append(", uodateTime=").append(uodateTime);
        sb.append(", apklocpath=").append(apklocpath);
        sb.append(", apkfilename=").append(apkfilename);
        sb.append(", versioninfo=").append(versioninfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}