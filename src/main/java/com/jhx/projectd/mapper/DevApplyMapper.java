package com.jhx.projectd.mapper;

import com.jhx.projectd.entity.DevApply;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DevApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    int insert(DevApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    DevApply selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    List<DevApply> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_apply
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DevApply record);
    int updateByDevId(int devId,int statusAfter);
    List<HashMap<String,Object>> selectByDevId(@Param("params") Map<String,String> params);
}