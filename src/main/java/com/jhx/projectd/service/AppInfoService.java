package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppInfo;
import com.jhx.projectd.mapper.AppInfoMapper;
import com.jhx.projectd.utils.AppListColumn;
import com.jhx.projectd.utils.AppListPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        return appInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AppInfo> selectAll() {
        return appInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AppInfo record) {
        return 0;
    }

    @Override
    public List<AppInfo> selectByAPKName(String name) {
        return appInfoMapper.selectByAPKName(name) ;
    }

    @Override
    public List<AppListColumn> selectByParams(AppListPageInfo params) {
        return appInfoMapper.selectByParams(params);
    }
}
