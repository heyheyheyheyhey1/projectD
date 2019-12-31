package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppStatus;
import com.jhx.projectd.mapper.AppStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppStatusService implements AppStatusMapper {
    @Autowired
    AppStatusMapper appStatusMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AppStatus record) {
        return 0;
    }

    @Override
    public AppStatus selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<AppStatus> selectAll() {
        return appStatusMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AppStatus record) {
        return 0;
    }

    @Override
    public List<AppStatus> selectByTypeCode(int code) {
        return appStatusMapper.selectByTypeCode(code);
    }

    @Override
    public List<AppStatus> selectByValue(int valueId) {
        return appStatusMapper.selectByValue(valueId);
    }

}
