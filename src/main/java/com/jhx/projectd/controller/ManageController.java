package com.jhx.projectd.controller;

import com.jhx.projectd.entity.AdminUser;
import com.jhx.projectd.entity.AppCategory;
import com.jhx.projectd.entity.AppInfo;
import com.jhx.projectd.entity.AppStatus;
import com.jhx.projectd.service.AdminUserService;
import com.jhx.projectd.service.AppInfoService;
import com.jhx.projectd.service.AppStatusService;
import com.jhx.projectd.service.AppCategoryService;
import com.jhx.projectd.utils.AppListColumn;
import com.jhx.projectd.utils.AppListPageInfo;
import org.eclipse.jdt.internal.compiler.env.IModulePathEntry;
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
    @Autowired
    private AppInfoService appInfoService;
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
            HttpSession session = request.getSession();
            session.setAttribute("adminId",adminUsers.get(0).getId());
            model.addAttribute("userSession",adminUsers.get(0));
            return "redirect:main";
        }

    }
    @GetMapping("main")
    public String getMain(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        if (adminUsers.size()== 0) return "/";

        else {
            model.addAttribute("userSession",adminUsers.get(0));
            return "backend/main";
        }
    }
    @GetMapping("backend/app/list")
    public String getAppList(Model model,HttpServletRequest request){
        System.out.println("开始进入backend/app/list！");
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppStatus> appStatuses = appStatusService.selectByValue2(2);
        model.addAttribute("userSession",adminUsers.get(0));
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));

        return "backend/applist";
    }
    @PostMapping("backend/app/list")
    public String appSearch(Model model,HttpServletRequest request, @ModelAttribute AppListPageInfo pageInfo){
        System.out.println("============================================");
        System.out.println("开始查询未审核名单!");
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        pageInfo.setQueryStatusId(2);
        System.out.println(pageInfo.toString());
        List<AppListColumn> appListColumns = appInfoService.selectByParams(pageInfo);
        List<AppCategory> appCategories = appCategoryService.selectByLevel(1);
        model.addAttribute("appInfoList",appListColumns);
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        int parentId = appCategories.get(0).getId();
        model.addAttribute("categoryLevel2List",appCategoryService.selectByParentId(pageInfo.getQueryCategoryLevel2Id()==null?2:pageInfo.getQueryCategoryLevel1Id()));
        List<AppCategory> appCategories2 = appCategoryService.selectByParentId(parentId);
        model.addAttribute("categoryLevel3List",appCategoryService.selectByParentId(pageInfo.getQueryCategoryLevel3Id()==null?3:pageInfo.getQueryCategoryLevel2Id()));
        model.addAttribute("pageInfo",pageInfo);
        //model.addAttribute("pages",)
        return "backend/applist";
    }
    @ResponseBody
    @GetMapping("backend/app/categorylevellist.json")
    public List<AppCategory> getCategory(@RequestParam(value = "pid",defaultValue = "0")int pid){
        return appCategoryService.selectByParentId(pid);
    }

}
