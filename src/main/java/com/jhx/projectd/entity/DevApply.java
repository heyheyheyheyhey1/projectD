package com.jhx.projectd.entity;

import java.io.Serializable;
import java.util.Date;

public class DevApply implements Serializable {


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.devId
     *
     * @mbg.generated
     */
    private Integer devId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.create_time
     *
     * @mbg.generated
     */
    private Date create_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.update_time
     *
     * @mbg.generated
     */
    private Date update_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_apply.applyInfo
     *
     * @mbg.generated
     */
    private String applyInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.id
     *
     * @return the value of dev_apply.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.id
     *
     * @param id the value for dev_apply.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.devId
     *
     * @return the value of dev_apply.devId
     *
     * @mbg.generated
     */
    public Integer getDevId() {
        return devId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.devId
     *
     * @param devId the value for dev_apply.devId
     *
     * @mbg.generated
     */
    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.create_time
     *
     * @return the value of dev_apply.create_time
     *
     * @mbg.generated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.create_time
     *
     * @param create_time the value for dev_apply.create_time
     *
     * @mbg.generated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.update_time
     *
     * @return the value of dev_apply.update_time
     *
     * @mbg.generated
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.update_time
     *
     * @param update_time the value for dev_apply.update_time
     *
     * @mbg.generated
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.status
     *
     * @return the value of dev_apply.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.status
     *
     * @param status the value for dev_apply.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_apply.applyInfo
     *
     * @return the value of dev_apply.applyInfo
     *
     * @mbg.generated
     */
    public String getApplyInfo() {
        return applyInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_apply.applyInfo
     *
     * @param applyInfo the value for dev_apply.applyInfo
     *
     * @mbg.generated
     */
    public void setApplyInfo(String applyInfo) {
        this.applyInfo = applyInfo == null ? null : applyInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
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
        sb.append(", devId=").append(devId);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", status=").append(status);
        sb.append(", applyInfo=").append(applyInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}