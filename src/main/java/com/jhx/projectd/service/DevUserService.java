package com.jhx.projectd.service;

import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.mapper.DevUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DevUserService implements DevUserMapper {

    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(DevUser record) {
        return 0;
    }

    @Override
    public DevUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<DevUser> selectAll() {
        return devUserMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DevUser record) {
        return 0;
    }
}
