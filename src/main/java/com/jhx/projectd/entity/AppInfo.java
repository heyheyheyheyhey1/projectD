package com.jhx.projectd.entity;

import com.jhx.projectd.utils.AddNewAppPageInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AppInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.softwareName
     *
     * @mbg.generated
     */
    private String softwareName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.softwareSize
     *
     * @mbg.generated
     */
    private BigDecimal softwareSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.cateLevel1
     *
     * @mbg.generated
     */
    private Integer cateLevel1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.cateLevel2
     *
     * @mbg.generated
     */
    private Integer cateLevel2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.APKName
     *
     * @mbg.generated
     */
    private String APKName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.devId
     *
     * @mbg.generated
     */
    private Integer devId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.logoPicPath
     *
     * @mbg.generated
     */
    private String logoPicPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.versionId
     *
     * @mbg.generated
     */
    private Integer versionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.download
     *
     * @mbg.generated
     */
    private Long download;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.supportRom
     *
     * @mbg.generated
     */
    private String supportRom;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.create_time
     *
     * @mbg.generated
     */
    private Date create_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.update_time
     *
     * @mbg.generated
     */
    private Date update_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.logoLocPath
     *
     * @mbg.generated
     */
    private String logoLocPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.onSaleDate
     *
     * @mbg.generated
     */
    private Date onSaleDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.cateLevel3
     *
     * @mbg.generated
     */
    private Integer cateLevel3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.flatformId
     *
     * @mbg.generated
     */
    private Integer flatformId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_info.appInfo
     *
     * @mbg.generated
     */
    private String appInfo;
    private String interfaceLanguage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;


    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.id
     *
     * @return the value of app_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.id
     *
     * @param id the value for app_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.softwareName
     *
     * @return the value of app_info.softwareName
     *
     * @mbg.generated
     */
    public String getSoftwareName() {
        return softwareName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.softwareName
     *
     * @param softwareName the value for app_info.softwareName
     *
     * @mbg.generated
     */
    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName == null ? null : softwareName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.softwareSize
     *
     * @return the value of app_info.softwareSize
     *
     * @mbg.generated
     */
    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.softwareSize
     *
     * @param softwareSize the value for app_info.softwareSize
     *
     * @mbg.generated
     */
    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.status
     *
     * @return the value of app_info.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.status
     *
     * @param status the value for app_info.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.cateLevel1
     *
     * @return the value of app_info.cateLevel1
     *
     * @mbg.generated
     */
    public Integer getCateLevel1() {
        return cateLevel1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.cateLevel1
     *
     * @param cateLevel1 the value for app_info.cateLevel1
     *
     * @mbg.generated
     */
    public void setCateLevel1(Integer cateLevel1) {
        this.cateLevel1 = cateLevel1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.cateLevel2
     *
     * @return the value of app_info.cateLevel2
     *
     * @mbg.generated
     */
    public Integer getCateLevel2() {
        return cateLevel2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.cateLevel2
     *
     * @param cateLevel2 the value for app_info.cateLevel2
     *
     * @mbg.generated
     */
    public void setCateLevel2(Integer cateLevel2) {
        this.cateLevel2 = cateLevel2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.APKName
     *
     * @return the value of app_info.APKName
     *
     * @mbg.generated
     */
    public String getAPKName() {
        return APKName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.APKName
     *
     * @param APKName the value for app_info.APKName
     *
     * @mbg.generated
     */
    public void setAPKName(String APKName) {
        this.APKName = APKName == null ? null : APKName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.devId
     *
     * @return the value of app_info.devId
     *
     * @mbg.generated
     */
    public Integer getDevId() {
        return devId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.devId
     *
     * @param devId the value for app_info.devId
     *
     * @mbg.generated
     */
    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.logoPicPath
     *
     * @return the value of app_info.logoPicPath
     *
     * @mbg.generated
     */
    public String getLogoPicPath() {
        return logoPicPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.logoPicPath
     *
     * @param logoPicPath the value for app_info.logoPicPath
     *
     * @mbg.generated
     */
    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath == null ? null : logoPicPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.versionId
     *
     * @return the value of app_info.versionId
     *
     * @mbg.generated
     */
    public Integer getVersionId() {
        return versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.versionId
     *
     * @param versionId the value for app_info.versionId
     *
     * @mbg.generated
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.download
     *
     * @return the value of app_info.download
     *
     * @mbg.generated
     */
    public Long getDownload() {
        return download;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.download
     *
     * @param download the value for app_info.download
     *
     * @mbg.generated
     */
    public void setDownload(Long download) {
        this.download = download;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.supportRom
     *
     * @return the value of app_info.supportRom
     *
     * @mbg.generated
     */
    public String getSupportRom() {
        return supportRom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.supportRom
     *
     * @param supportRom the value for app_info.supportRom
     *
     * @mbg.generated
     */
    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom == null ? null : supportRom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.create_time
     *
     * @return the value of app_info.create_time
     *
     * @mbg.generated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.create_time
     *
     * @param create_time the value for app_info.create_time
     *
     * @mbg.generated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.update_time
     *
     * @return the value of app_info.update_time
     *
     * @mbg.generated
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.update_time
     *
     * @param update_time the value for app_info.update_time
     *
     * @mbg.generated
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.logoLocPath
     *
     * @return the value of app_info.logoLocPath
     *
     * @mbg.generated
     */
    public String getLogoLocPath() {
        return logoLocPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.logoLocPath
     *
     * @param logoLocPath the value for app_info.logoLocPath
     *
     * @mbg.generated
     */
    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath == null ? null : logoLocPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.onSaleDate
     *
     * @return the value of app_info.onSaleDate
     *
     * @mbg.generated
     */
    public Date getOnSaleDate() {
        return onSaleDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.onSaleDate
     *
     * @param onSaleDate the value for app_info.onSaleDate
     *
     * @mbg.generated
     */
    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.cateLevel3
     *
     * @return the value of app_info.cateLevel3
     *
     * @mbg.generated
     */
    public Integer getCateLevel3() {
        return cateLevel3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.cateLevel3
     *
     * @param cateLevel3 the value for app_info.cateLevel3
     *
     * @mbg.generated
     */
    public void setCateLevel3(Integer cateLevel3) {
        this.cateLevel3 = cateLevel3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.flatformId
     *
     * @return the value of app_info.flatformId
     *
     * @mbg.generated
     */
    public Integer getFlatformId() {
        return flatformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.flatformId
     *
     * @param flatformId the value for app_info.flatformId
     *
     * @mbg.generated
     */
    public void setFlatformId(Integer flatformId) {
        this.flatformId = flatformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.appInfo
     *
     * @return the value of app_info.appInfo
     *
     * @mbg.generated
     */
    public String getAppInfo() {
        return appInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.appInfo
     *
     * @param appInfo the value for app_info.appInfo
     *
     * @mbg.generated
     */
    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo == null ? null : appInfo.trim();
    }
    public AppInfo(){

    }
    public AppInfo(AddNewAppPageInfo pageInfo, String absolutePath) {

        setFlatformId(pageInfo.getFlatformId());
        setLogoLocPath(absolutePath);
        setLogoPicPath(pageInfo.getA_logoPicPath().getOriginalFilename());
        setDownload(pageInfo.getDownloads());
        setSoftwareName(pageInfo.getSoftwareName());
        setAPKName(pageInfo.getAPKName());
        setCateLevel1(pageInfo.getCategoryLevel1());
        setCateLevel2(pageInfo.getCategoryLevel2());
        setCateLevel3(pageInfo.getCategoryLevel3());
        setDevId(pageInfo.getDevId());
        setStatus(pageInfo.getStatus());
        setAppInfo(pageInfo.getAppInfo());
        setSoftwareSize(pageInfo.getSoftwareSize());
        setInterfaceLanguage(pageInfo.getInterfaceLanguage());
        setSupportRom(pageInfo.getSupportROM());

    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
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
        sb.append(", softwareName=").append(softwareName);
        sb.append(", softwareSize=").append(softwareSize);
        sb.append(", status=").append(status);
        sb.append(", cateLevel1=").append(cateLevel1);
        sb.append(", cateLevel2=").append(cateLevel2);
        sb.append(", APKName=").append(APKName);
        sb.append(", devId=").append(devId);
        sb.append(", logoPicPath=").append(logoPicPath);
        sb.append(", versionId=").append(versionId);
        sb.append(", download=").append(download);
        sb.append(", supportRom=").append(supportRom);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", logoLocPath=").append(logoLocPath);
        sb.append(", onSaleDate=").append(onSaleDate);
        sb.append(", cateLevel3=").append(cateLevel3);
        sb.append(", flatformId=").append(flatformId);
        sb.append(", appInfo=").append(appInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}