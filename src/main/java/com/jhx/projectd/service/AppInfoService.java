package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppInfo;
import com.jhx.projectd.mapper.AppInfoMapper;
import com.jhx.projectd.utils.AppListColumn;
import com.jhx.projectd.utils.AppListPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppInfoService implements AppInfoMapper {
    @Autowired
    AppInfoMapper appInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AppInfo record) {
        return 0;
    }

    @Override
    public AppInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<AppInfo> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(AppInfo record) {
        return 0;
    }

    @Override
    public List<AppListColumn> selectByParams(Object params) {
        return appInfoMapper.selectByParams(params);
    }
}
