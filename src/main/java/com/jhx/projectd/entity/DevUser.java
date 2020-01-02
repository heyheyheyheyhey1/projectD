package com.jhx.projectd.entity;

import java.io.Serializable;
import java.util.Date;

public class DevUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.devName
     *
     * @mbg.generated
     */
    private String devName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.devPassword
     *
     * @mbg.generated
     */
    private String devPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.devEmail
     *
     * @mbg.generated
     */
    private String devEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.create_time
     *
     * @mbg.generated
     */
    private Date create_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.update_time
     *
     * @mbg.generated
     */
    private Date update_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.devCode
     *
     * @mbg.generated
     */
    private Integer devCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_user.devInfo
     *
     * @mbg.generated
     */
    private String devInfo;

    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dev_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.id
     *
     * @return the value of dev_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.id
     *
     * @param id the value for dev_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.devName
     *
     * @return the value of dev_user.devName
     *
     * @mbg.generated
     */
    public String getDevName() {
        return devName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.devName
     *
     * @param devName the value for dev_user.devName
     *
     * @mbg.generated
     */
    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.devPassword
     *
     * @return the value of dev_user.devPassword
     *
     * @mbg.generated
     */
    public String getDevPassword() {
        return devPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.devPassword
     *
     * @param devPassword the value for dev_user.devPassword
     *
     * @mbg.generated
     */
    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword == null ? null : devPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.devEmail
     *
     * @return the value of dev_user.devEmail
     *
     * @mbg.generated
     */
    public String getDevEmail() {
        return devEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.devEmail
     *
     * @param devEmail the value for dev_user.devEmail
     *
     * @mbg.generated
     */
    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail == null ? null : devEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.create_time
     *
     * @return the value of dev_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.create_time
     *
     * @param create_time the value for dev_user.create_time
     *
     * @mbg.generated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.update_time
     *
     * @return the value of dev_user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.update_time
     *
     * @param update_time the value for dev_user.update_time
     *
     * @mbg.generated
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.devCode
     *
     * @return the value of dev_user.devCode
     *
     * @mbg.generated
     */
    public Integer getDevCode() {
        return devCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.devCode
     *
     * @param devCode the value for dev_user.devCode
     *
     * @mbg.generated
     */
    public void setDevCode(Integer devCode) {
        this.devCode = devCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_user.devInfo
     *
     * @return the value of dev_user.devInfo
     *
     * @mbg.generated
     */
    public String getDevInfo() {
        return devInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_user.devInfo
     *
     * @param devInfo the value for dev_user.devInfo
     *
     * @mbg.generated
     */
    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo == null ? null : devInfo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
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
        sb.append(", devName=").append(devName);
        sb.append(", devPassword=").append(devPassword);
        sb.append(", devEmail=").append(devEmail);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", devCode=").append(devCode);
        sb.append(", devInfo=").append(devInfo);
        sb.append(". status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}