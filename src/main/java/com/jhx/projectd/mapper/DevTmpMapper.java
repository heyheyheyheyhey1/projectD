package com.jhx.projectd.mapper;

import com.jhx.projectd.entity.DevTmp;
import java.util.List;

public interface DevTmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_tmp
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_tmp
     *
     * @mbg.generated
     */
    int insert(DevTmp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_tmp
     *
     * @mbg.generated
     */
    DevTmp selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_tmp
     *
     * @mbg.generated
     */
    List<DevTmp> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_tmp
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DevTmp record);
}