package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppVersion;
import com.jhx.projectd.mapper.AppInfoMapper;
import com.jhx.projectd.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AppVersionService implements AppVersionMapper {
    @Autowired
    AppVersionMapper appVersionMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AppVersion record) {
        appVersionMapper.insert(record);
        return 0;
    }

    @Override
    public AppVersion selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<AppVersion> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(AppVersion record) {
        return 0;
    }

    @Override
    public int deleteByAppId(Integer id) {
        appVersionMapper.deleteByAppId(id);
        return 0;
    }

    @Override
    public List<AppVersion> selectByAppId(Integer id) {
        return appVersionMapper.selectByAppId(id);
    }

    @Override
    public List<HashMap<String, Object>> selectFullInfoByAppId(Integer appId) {
        return appVersionMapper.selectFullInfoByAppId(appId);
    }

}
