package com.jhx.projectd.mapper;

import com.jhx.projectd.entity.AppStatus;
import java.util.List;

public interface AppStatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
     *
     * @mbg.generated
     */
    int insert(AppStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
     *
     * @mbg.generated
     */
    AppStatus selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
     *
     * @mbg.generated
     */
    List<AppStatus> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_status
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AppStatus record);
    List<AppStatus> selectByTypeCode(int code);
    List<AppStatus> selectByValue(int valueId);

}