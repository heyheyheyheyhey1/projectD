package com.jhx.projectd.service;

import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.mapper.DevUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        devUserMapper.insert(record);
        return 0;
    }

    @Override
    public DevUser selectByPrimaryKey(Integer id) {
        return devUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public DevUser selectByDevCode(Integer code) {
        return  devUserMapper.selectByDevCode(code);

    }

    @Override
    public List<DevUser> selectAll() {
        return devUserMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DevUser record) {
        devUserMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<DevUser> selectByDevCodeAndPassword(String devCode, String password) {
        return devUserMapper.selectByDevCodeAndPassword(devCode,password);
    }

    @Override
    public List<HashMap<String, Object>> selectByParam2(Map<String, String> params) {
        return devUserMapper.selectByParam2(params);
    }

    @Override
    public int updateByDid(int did,int statusAfter) {
        return devUserMapper.updateByDid(did,statusAfter);
    }


    public DevUser selectByIdFromSession(HttpSession session){
        if (session.getAttribute("devId")==null) {
            System.out.println("session没找到Id");
            return null;
        }
        return this.selectByPrimaryKey((Integer) session.getAttribute("devId"));
    }
}
