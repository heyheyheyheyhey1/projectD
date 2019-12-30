package com.jhx.projectd.controller;

import com.jhx.projectd.entity.AdminUser;
import com.jhx.projectd.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManageController {
    @Autowired
    private AdminUserService adminUserService;
    @GetMapping("login")
    public String getAdminLogin(){
        return "backendlogin";
    }
    @PostMapping("dologin")
    public String verify(Model model, @RequestParam(value = "userCode",defaultValue = "")String userCode,
                         @RequestParam(value = "userPassword",defaultValue = "")String userPassword){
        System.out.println("管理员开始登陆！");
        List<AdminUser> adminUsers = adminUserService.selectByAdminUserAndPassword(userCode,userPassword);
        Iterator<AdminUser> u = adminUsers.iterator();
        while (u.hasNext()){
            System.out.println(u.next().toString());
        }
        int checkUser = adminUsers.size();
        if(checkUser == 0){
            System.out.println("false");
            return "backendlogin";
        }
        else{
            System.out.println("true");
            model.addAttribute("userSession",adminUsers.get(0));
            return "backend/main";
        }

    }

}
