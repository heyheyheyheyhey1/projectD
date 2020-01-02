package com.jhx.projectd.controller;

import com.jhx.projectd.entity.*;
import com.jhx.projectd.service.*;
import com.jhx.projectd.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AppVersionService appVersionService;
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
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        else {
            Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());
            List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
            model.addAttribute("userSession",adminUsers.get(0));
            return "backend/main";
        }
    }
    @GetMapping("backend/app/list")
    public String getAppList(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        System.out.println("开始进入backend/app/list！");
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
    public String appSearch(Model model,HttpServletRequest request, @RequestParam  HashMap<String,String> pageInfo,
                            @RequestParam(value = "pageIndex",defaultValue = "1")int currentPageNo,
                            @RequestParam(value = "pageSize",defaultValue = "5")int pageSize){
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        System.out.println("============================================");
        System.out.println("开始查询未审核名单!");
        System.out.println(pageInfo.toString());
        pageInfo.put("queryStatusId",String.valueOf(2));
        List<HashMap<String,Object>> appListColumns = appInfoService.selectByParams(pageInfo);
        PageInfo<HashMap<String,Object>> pages = new PageInfo<>();
        pages.setList(sub(appListColumns,currentPageNo,pageSize));
        int totalCount = appListColumns.size();
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pages.setCurrentPageNo(currentPageNo);
        pages.setTotalPageCount(totalPageCount);
        pages.setTotalCount(totalCount);
        System.out.println("总页数" + totalPageCount);
        System.out.println("当前页是：" + currentPageNo);
        System.out.println("分页数据：");
        System.out.println(pages.getList());

        model.addAttribute("pages",pages);
        model.addAttribute("appInfoList",pages.getList());
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        model.addAttribute("categoryLevel2List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel1Id")!=null&&pageInfo.get("queryCategoryLevel1Id")!=""? Integer.parseInt(pageInfo.get("queryCategoryLevel1Id")):2));
        model.addAttribute("categoryLevel3List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel2Id")!=null&&pageInfo.get("queryCategoryLevel2Id")!=""?Integer.parseInt(pageInfo.get("queryCategoryLevel2Id")):3));
        model.addAttribute("pageInfo",pageInfo);
        return "backend/applist";
    }
    public List<HashMap<String,Object>> sub(List<HashMap<String,Object>> s,int totalPageCount,int pageSize){
        int start=(totalPageCount-1)*pageSize;
        int end=start+pageSize <s.size()?start+pageSize:s.size();
        return s.subList(start,end);
    }

    @GetMapping("backend/app/check")
    public String appCheck(Model model,HttpServletRequest request,
                           @RequestParam(value = "aid",defaultValue = "0")int aid,
                           @RequestParam(value = "vid",defaultValue = "0")int vid){
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        System.out.println("============================================");
        System.out.println("开始审核!");
        System.out.println("aid is : " +aid+"。。。vid is : "+vid );
        session.setAttribute("aid",aid);
        session.setAttribute("vid",vid);
        Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());

        Map<String,String> pageInfo=new HashMap<>();
        pageInfo.put("queryAid",String.valueOf(aid));
        pageInfo.put("queryVid",String.valueOf(vid));
        List<HashMap<String,Object>> list=appInfoService.selectByParam2(pageInfo);
        System.out.println(list.toString());

        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppInfo> appInfos = appInfoService.selectByIdAndVersionId(aid,vid);
        List<AppVersion> appVersion = appVersionService.selectByVersionId(aid,vid);
        System.out.println(appVersion.toString());
        model.addAttribute("userSession",adminUsers.get(0));
        model.addAttribute("appInfo",list.get(0));
        model.addAttribute("appVersion",appVersion.get(0));

        return "backend/appcheck";
    }
    @PostMapping("backend/app/checksave")
    public String appCheckSave(Model model,@RequestParam(value = "status",defaultValue = "")String status,
                HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId")== null) return "redirect:/manager/login";
        System.out.println("审核进行中！");
        System.out.println(status);
        Integer aid=Integer.parseInt(session.getAttribute("aid").toString());
        Integer vid=Integer.parseInt(session.getAttribute("vid").toString());
        Integer adminId=Integer.parseInt(session.getAttribute("adminId").toString());
        //response.setContentType("text/html; charset=utf-8");
        //OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
        if(status.equals("3"))
        {
            int statusAfter = Integer.parseInt(status);
            int change = appInfoService.updateByAidAndVid(aid,vid,statusAfter);
            if(change == 0) {
                System.out.println(" Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核通过失败！");
                model.addAttribute("errorInfo","数据审核通过失败！");
                return "403";
            }
            if(change == 1) {
                System.out.println(" Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核通过成功！");
                model.addAttribute("result","数据审核通过成功！");
                return "200";
            }
        }
        else if(status.equals("13"))
        {
            int statusAfter = Integer.parseInt(status);
            int change = appInfoService.updateByAidAndVid(aid,vid,statusAfter);
            if(change == 0) {
                System.out.println("更新 Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核不通过失败！");
                model.addAttribute("errorInfo","数据审核不通过失败！");
                return "403";
            }
            if(change == 1) {
                System.out.println("更新 Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核不通过成功！");
                model.addAttribute("result","数据审核不通过成功！");
                return "200";
            }
        }
        Map<String,String> pageInfo=new HashMap<>();
        pageInfo.put("queryAid",String.valueOf(aid));
        pageInfo.put("queryVid",String.valueOf(vid));
        List<HashMap<String,Object>> list=appInfoService.selectByParam2(pageInfo);
        System.out.println(list.toString());

        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppInfo> appInfos = appInfoService.selectByIdAndVersionId(aid,vid);
        List<AppVersion> appVersion = appVersionService.selectByVersionId(aid,vid);
        System.out.println(appVersion.toString());
        model.addAttribute("userSession",adminUsers.get(0));
        model.addAttribute("appInfo",list.get(0));
        model.addAttribute("appVersion",appVersion.get(0));

        return "backend/appcheck";
    }
    @ResponseBody
    @GetMapping("backend/app/categorylevellist.json")
    public List<AppCategory> getCategory(@RequestParam(value = "pid",defaultValue = "0")int pid){
        return appCategoryService.selectByParentId(pid);
    }

}
