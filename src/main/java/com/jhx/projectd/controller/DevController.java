package com.jhx.projectd.controller;

import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/dev")
public class DevController {
    @Autowired
    DevUserService devUserService;
    @GetMapping("login")
    public String devLogin(){
        return "devlogin";
    }

    @PostMapping("dologin")
    public String doLogin(Model model, @RequestParam("devCode")String devCode, @RequestParam("devPassword") String password, HttpServletRequest request){
        System.out.println(devCode+password);
        List<DevUser> list = devUserService.selectByDevCodeAndPassword(devCode,password);
        if (list.size()==1){
            request.getSession().setAttribute("devId",list.get(0).getId());
            return "redirect:flatform/app/main";
        }
        else {
            model.addAttribute("error","没这个人");
            return "devlogin";
        }
    }

    @GetMapping("flatform/app/main")
    public String devMain(Model model,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null) {
            System.out.println("没找到啊");
            return "/";
        }
        model.addAttribute("devUserSession",devUser);
        return "developer/main";

    }

    @GetMapping("flatform/app/list")
    public String devAppList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null) return "/";
        model.addAttribute("devUserSession",devUser);
        return "developer/appinfolist";
    }
}