package com.jhx.projectd.mapper;

import com.jhx.projectd.entity.DevUser;
import java.util.List;

public interface DevUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
     *
     * @mbg.generated
     */
    int insert(DevUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
     *
     * @mbg.generated
     */
    DevUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
     *
     * @mbg.generated
     */
    List<DevUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_user
     *
     * @mbg.generated
     */

    int updateByPrimaryKey(DevUser record);

    List<DevUser> selectByDevCodeAndPassword(String devCode, String password);
}