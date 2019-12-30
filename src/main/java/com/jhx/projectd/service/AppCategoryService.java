package com.jhx.projectd.service;

import com.jhx.projectd.entity.AppCategory;
import com.jhx.projectd.mapper.AppCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppCategoryService implements AppCategoryMapper {
    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AppCategory record) {
        return 0;
    }

    @Override
    public AppCategory selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<AppCategory> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(AppCategory record) {
        return 0;
    }

    @Override
    public List<AppCategory> selectByLevel(int level) {
        return appCategoryMapper.selectByLevel(level);
    }

    @Override
    public List<AppCategory> selectByParentId(int pid) {
        return appCategoryMapper.selectByParentId(pid);
    }
}
