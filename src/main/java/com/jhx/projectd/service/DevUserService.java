package com.jhx.projectd.service;

import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.mapper.DevUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
        return devUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DevUser> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DevUser record) {
        return 0;
    }

    @Override
    public List<DevUser> selectByDevCodeAndPassword(String devCode, String password) {
        return devUserMapper.selectByDevCodeAndPassword(devCode,password);
    }



    public DevUser selectByIdFromSession(HttpSession session){
        if (session.getAttribute("devId")==null) {
            System.out.println("session没找到Id");
            return null;
        }
        return this.selectByPrimaryKey((Integer) session.getAttribute("devId"));
    }
}
