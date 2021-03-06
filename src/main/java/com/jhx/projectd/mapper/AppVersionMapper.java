package com.jhx.projectd.mapper;

import com.jhx.projectd.entity.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AppVersionMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    int insert(AppVersion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    AppVersion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    List<AppVersion> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AppVersion record);
    int deleteByAppId(Integer id);
    List<AppVersion> selectByAppId(Integer id);
    List<HashMap<String,Object>> selectFullInfoByAppId(Integer appId);

    List<AppVersion> selectByVersionId(int aid, int vid);
    List<AppVersion> selectByVersionNo(@Param("aid") int aid, @Param("vno") String vno);

}