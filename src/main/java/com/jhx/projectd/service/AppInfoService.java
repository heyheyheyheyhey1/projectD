package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppInfo;
import com.jhx.projectd.mapper.AppInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppInfoService implements AppInfoMapper {

    @Autowired
    AppInfoMapper appInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        appInfoMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(AppInfo record) {
        appInfoMapper.insert(record);
        return 0;
    }

    @Override
    public AppInfo selectByPrimaryKey(Integer id) {
        return appInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AppInfo> selectAll() {
        return appInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AppInfo record) {
        appInfoMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<AppInfo> selectByAPKName(String name) {
        return appInfoMapper.selectByAPKName(name) ;
    }

    @Override
    public List<HashMap<String,Object>> selectByParams(Map<String,String> params) {
        return appInfoMapper.selectByParams(params);
    }
}
