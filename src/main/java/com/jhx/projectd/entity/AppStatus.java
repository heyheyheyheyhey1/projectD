package com.jhx.projectd.entity;

import java.io.Serializable;
import java.util.Date;

public class AppStatus implements Serializable {
    public static final Integer STATUS_NOT_PERMITTED=23;
    public static final Integer STATUS_WAITING_REVIEW=21;
    public static final Integer STATUS_PERMITTED=22;
    public static final Integer STATUS_DISABLE=24;
    public static final Integer APP_STATUS_PERMITTED=3;
    public static final Integer APP_STATUS_ON_SALE=1;
    public static final Integer APP_STATUS_NOT_PERMITTED=13;
    public static final Integer APP_STATUS_WAITING_REVIEW=2;
    public static final Integer APP_STATUS_WAITING_SALE=10;
    public static final Integer APP_STATUS_OFF_SALE=9;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.typeName
     *
     * @mbg.generated
     */
    private String typeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.update_time
     *
     * @mbg.generated
     */
    private Date update_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.create_time
     *
     * @mbg.generated
     */
    private Date create_time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.typeCode
     *
     * @mbg.generated
     */
    private String typeCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.valueId
     *
     * @mbg.generated
     */
    private Integer valueId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_status.valueName
     *
     * @mbg.generated
     */
    private String valueName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_status
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.id
     *
     * @return the value of app_status.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.id
     *
     * @param id the value for app_status.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.typeName
     *
     * @return the value of app_status.typeName
     *
     * @mbg.generated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.typeName
     *
     * @param typeName the value for app_status.typeName
     *
     * @mbg.generated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.update_time
     *
     * @return the value of app_status.update_time
     *
     * @mbg.generated
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.update_time
     *
     * @param update_time the value for app_status.update_time
     *
     * @mbg.generated
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.create_time
     *
     * @return the value of app_status.create_time
     *
     * @mbg.generated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.create_time
     *
     * @param create_time the value for app_status.create_time
     *
     * @mbg.generated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.typeCode
     *
     * @return the value of app_status.typeCode
     *
     * @mbg.generated
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.typeCode
     *
     * @param typeCode the value for app_status.typeCode
     *
     * @mbg.generated
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.valueId
     *
     * @return the value of app_status.valueId
     *
     * @mbg.generated
     */
    public Integer getValueId() {
        return valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.valueId
     *
     * @param valueId the value for app_status.valueId
     *
     * @mbg.generated
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_status.valueName
     *
     * @return the value of app_status.valueName
     *
     * @mbg.generated
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_status.valueName
     *
     * @param valueName the value for app_status.valueName
     *
     * @mbg.generated
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
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
        sb.append(", typeName=").append(typeName);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_time=").append(create_time);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", valueId=").append(valueId);
        sb.append(", valueName=").append(valueName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}