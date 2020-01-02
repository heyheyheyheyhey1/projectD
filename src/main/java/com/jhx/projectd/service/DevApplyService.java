package com.jhx.projectd.service;

import com.jhx.projectd.entity.DevApply;
import com.jhx.projectd.mapper.DevApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DevApplyService implements DevApplyMapper {
    @Autowired
    DevApplyMapper devApplyMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(DevApply record) {
        devApplyMapper.insert(record);
        return 0;
    }

    @Override
    public DevApply selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<DevApply> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DevApply record) {
        return 0;
    }
}
