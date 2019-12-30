package com.jhx.projectd.service;

import com.jhx.projectd.entity.AdminUser;
import com.jhx.projectd.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService implements AdminUserMapper {

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AdminUser record) {
        return 0;
    }

    @Override
    public AdminUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<AdminUser> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(AdminUser record) {
        return 0;
    }

    @Override
    public List<AdminUser> selectByAdminUserAndPassword(String userCode, String userPassword) {
        return adminUserMapper.selectByAdminUserAndPassword(userCode,userPassword);
    }
}
