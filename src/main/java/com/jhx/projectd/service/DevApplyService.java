package com.jhx.projectd.service;

import com.jhx.projectd.entity.DevApply;
import com.jhx.projectd.mapper.DevApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        return devApplyMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<DevApply> selectAll() {
        return devApplyMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DevApply record) {
        devApplyMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public int updateByDevId(int devId, int statusAfter) {
        return devApplyMapper.updateByDevId(devId,statusAfter);
    }

}
