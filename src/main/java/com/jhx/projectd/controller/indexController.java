package com.jhx.projectd.controller;
import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.mapper.*;
import com.jhx.projectd.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class indexController {
    @Autowired
    private DevUserService devUserService;
    @GetMapping("/")
    public List<DevUser> getIndex(){
        System.out.println(devUserService.selectAll().size());
        return devUserService.selectAll();
    }
}
