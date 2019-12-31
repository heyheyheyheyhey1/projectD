package com.jhx.projectd.controller;
import com.alibaba.fastjson.JSON;
import com.jhx.projectd.entity.AppCategory;
import com.jhx.projectd.entity.AppInfo;
import com.jhx.projectd.entity.AppStatus;
import com.jhx.projectd.entity.DevUser;
import com.jhx.projectd.service.AppCategoryService;
import com.jhx.projectd.service.AppInfoService;
import com.jhx.projectd.service.AppStatusService;
import com.jhx.projectd.service.DevUserService;
import com.jhx.projectd.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/dev")
public class DevController {
    @Autowired
    DevUserService devUserService;
    @Autowired
    AppStatusService appStatusService;
    @Autowired
    AppCategoryService appCategoryService;
    @Autowired
    AppInfoService appInfoService;

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
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        return "developer/appinfolist";
    }

    @PostMapping("flatform/app/list")
    public String getAappList(Model model, @RequestParam HashMap <String ,String> pageInfo,HttpServletRequest request) {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        System.out.println(pageInfo.toString());
        if (devUser==null) return "redirect:/";
        pageInfo.put("devId",String.valueOf(devUser.getId()));

        model.addAttribute("devUserSession",devUser);
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        model.addAttribute("categoryLevel2List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel1Id")!=null&&pageInfo.get("queryCategoryLevel1Id")!=""?Integer.parseInt(pageInfo.get("queryCategoryLevel1Id")):2));
        model.addAttribute("categoryLevel3List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel2Id")!=null&&pageInfo.get("queryCategoryLevel2Id")!=""?Integer.parseInt(pageInfo.get("queryCategoryLevel2Id")):3));

        List<HashMap<String,Object>> list=appInfoService.selectByParams(pageInfo);

        if (list.size()!=0){
            System.out.println(list.size());
        }

        model.addAttribute("appInfoList",list);
        model.addAttribute("pageInfo",pageInfo);

        return "developer/appinfolist";
    }

    @ResponseBody
    @GetMapping("flatform/app/categorylevellist")
    public List<AppCategory>  catgrlevellist(@RequestParam("pid")Integer pid,HttpServletResponse response){
        if (pid!=null){
            return appCategoryService.selectByParentId(pid);
        }
        else{
            return appCategoryService.selectByLevel(1);
        }
    }
    @ResponseBody
    @GetMapping("flatform/app/queryFlatformList")
    public List<AppStatus>  queryFlatformList(@RequestParam("tCode")Integer tCode, HttpServletResponse response){
        if (tCode!=null){
            return appStatusService.selectByTypeCode(tCode);
        }
        else {
            return appStatusService.selectByTypeCode(2);
        }
    }


    @ResponseBody
    @GetMapping("flatform/app/apkexist")
    public Map<String, Object>  apkexist(@RequestParam("APKName")String APKName, HttpServletResponse response){
        Map<String ,Object> map = new HashMap<>();
        if (appInfoService.selectByAPKName(APKName).size()!=0) {

            map.put("status","false");
            map.put("info","有这个名字了");
            return map;
        }
        else {
            map.put("status","ok");
            map.put("info","操作成功");
            return map;
        }
    }

    @GetMapping("flatform/app/saleSwitch")
    @ResponseBody
    public Map<String,Object> saleSwitch(HttpServletRequest request,HttpServletResponse response,@RequestParam("appId")Integer appId){
        DevUser devUser=devUserService.selectByIdFromSession(request.getSession());
        AppInfo appInfo = appInfoService.selectByPrimaryKey(appId);
        Map<String,Object> map=new HashMap<>();

        if (appInfo==null||appInfo.getDevId()!=devUser.getId()){
            response.setStatus(403);
            map.put("status","false");
            map.put("info","没这个爱啪啪或者爱啪啪开发者与当前开发者不对应");
            return map;
        }
        System.out.println("===before"+appInfo.getStatus());
        appInfo.setStatus(appInfo.getStatus()==1?9:1);
        System.out.println("=====after"+appInfoService.selectByPrimaryKey(appInfo.getId()).getStatus());
        appInfoService.updateByPrimaryKey(appInfo);
        map.put("status","ok");
        map.put("info","操作成功");
        return map;
    }
    @GetMapping("flatform/app/appinfoadd")
    public String appInfoAd(Model model,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        return "developer/appinfoadd";
    }


    @PostMapping("flatform/app/appinfoaddsave")
    public String appInfoSave(Model model, @ModelAttribute AddNewAppPageInfo pageInfo, HttpServletRequest request) throws IOException {

        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        pageInfo.setDevId(devUser.getId());
        MultipartFile multipartFile = pageInfo.getA_logoPicPath();
        if (multipartFile==null||!UploadFileUtils.isImage(pageInfo.getA_logoPicPath())) {
            model.addAttribute("fileUploadError","你没有上传图片文件嗷");
            return "developer/appinfoadd";
        }
        if (appInfoService.selectByAPKName(pageInfo.getAPKName()).size()!=0){
            model.addAttribute("fileUploadError","注意APKName嗷");
            return "developer/appinfoadd";
        }

        System.out.println("文件大小"+pageInfo.getA_logoPicPath().getSize());
        System.out.println("文件绝对路径"+new File("./").getAbsolutePath());
        String absolutePath = UploadFileUtils.saveUploadfile(pageInfo.getA_logoPicPath());
        appInfoService.insert(new AppInfo(pageInfo,absolutePath));
        model.addAttribute("fileUploadError","上传完成了嗷");

        return "developer/appinfoadd";
    }

    @RequestMapping("flatform/app/appversionadd")
    public String addVersion(Model model,@RequestParam("id")Integer appId,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        return "developer/appversionadd";
    }

    @RequestMapping("flatform/app/addversionsave")
    public String addVersionSave(Model model, @ModelAttribute AppVersionPageInfo pageInfo, HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        System.out.println(pageInfo.getA_downloadLink().getSize());
        model.addAttribute("devUserSession",devUser);
        model.addAttribute("fileUploadError","添加版本成功!");
        return "developer/appversionadd";
    }

    @ResponseBody
    @RequestMapping("flatform/app/delapp")
    public Map<String,String> delApp(@RequestParam("id")Integer id){
        Map <String,String> map = new HashMap<>();
        AppInfo appInfo = appInfoService.selectByPrimaryKey(id);
        if (appInfo==null||appInfo.getDevId()!=id){
            map.put("status","failed");
            map.put("info","没这app或者你不是这个app与开发者不对应");
        }
        appInfoService.deleteByPrimaryKey(id);
        map.put("status","ok");
        map.put("info","");
        return map;
    }
}