package com.jhx.projectd.controller;

import com.jhx.projectd.entity.AdminUser;
import com.jhx.projectd.entity.AppCategory;
import com.jhx.projectd.entity.AppStatus;
import com.jhx.projectd.service.AdminUserService;
import com.jhx.projectd.service.AppStatusService;
import com.jhx.projectd.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManageController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AppStatusService appStatusService;
    @Autowired
    private AppCategoryService appCategoryService;
    @GetMapping("login")
    public String getAdminLogin(){
        return "backendlogin";
    }
    @PostMapping("dologin")
    public String verify(Model model, @RequestParam(value = "userCode",defaultValue = "")String userCode,
                         @RequestParam(value = "userPassword",defaultValue = "")String userPassword,
                         HttpServletRequest request){
        System.out.println("管理员开始登陆！");
        List<AdminUser> adminUsers = adminUserService.selectByAdminUserAndPassword(userCode,userPassword);
        HttpSession session = request.getSession();
        //session.setAttribute("adminId",adminUsers.get(0).getId());
        //if (session.getAttribute("adminId")== null) return "backendlogin";
        Iterator<AdminUser> u = adminUsers.iterator();
        while (u.hasNext()){
            System.out.println(u.next().toString());
        }
        int checkUser = adminUsers.size();
        if(checkUser == 0){
            System.out.println("false");
            model.addAttribute("error","出问题了啊，检查一下！");
            return "backendlogin";
        }
        else{
            System.out.println("true");
            model.addAttribute("userSession",adminUsers.get(0));
            return "backend/main";
        }

    }
    @GetMapping("backend/app/list")
    public String getAppList(Model model,HttpServletRequest request){
        System.out.println("开始进入backend/app/list！");
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "backendlogin";
        Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppStatus> appStatuses = appStatusService.selectByValue2(2);
        model.addAttribute("userSession",adminUsers.get(0));
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        return "backend/applist";
    }
    @ResponseBody
    @GetMapping("backend/app/categorylevellist.json")
    public List<AppCategory> getCategory(@RequestParam(value = "pid",defaultValue = "0")int pid){
        return appCategoryService.selectByParentId(pid);
    }

}
