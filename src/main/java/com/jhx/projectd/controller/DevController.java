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
import com.jhx.projectd.utils.AppListColumn;
import com.jhx.projectd.utils.AppListPageInfo;
import com.jhx.projectd.utils.UnivsJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public String getAappList(Model model, @ModelAttribute AppListPageInfo pageInfo,HttpServletRequest request) {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());

        System.out.println(pageInfo.toString());
        if (devUser==null) return "redirect:/";
        pageInfo.setDevId(devUser.getId());
        model.addAttribute("devUserSession",devUser);
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        model.addAttribute("categoryLevel2List",appCategoryService.selectByParentId(pageInfo.getQueryCategoryLevel2Id()==null?2:pageInfo.getQueryCategoryLevel1Id()));
        model.addAttribute("categoryLevel3List",appCategoryService.selectByParentId(pageInfo.getQueryCategoryLevel3Id()==null?3:pageInfo.getQueryCategoryLevel2Id()));

        List<AppListColumn> list=appInfoService.selectByParams(pageInfo);
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
    public UnivsJson  apkexist(@RequestParam("APKName")String APKName, HttpServletResponse response){
        if (appInfoService.selectByAPKName(APKName).size()!=0) return new UnivsJson().setStatus("false").setInfo("不可用");
        else return new UnivsJson().setStatus("ok").setInfo("可用");
    }

    @GetMapping("flatform/app/saleSwitch")
    @ResponseBody
    public UnivsJson saleSwitch(HttpServletRequest request,HttpServletResponse response,@RequestParam("appId")Integer appId){
        DevUser devUser=devUserService.selectByIdFromSession(request.getSession());
        AppInfo appInfo = appInfoService.selectByPrimaryKey(appId);
        if (appInfo==null||appInfo.getDevId()!=devUser.getId()){
            response.setStatus(403);
            return new UnivsJson().setStatus("false").setInfo("没这个爱啪啪或者爱啪啪开发者与当前开发者不对应");
        }
        System.out.println("===before"+appInfo.getStatus());
        appInfo.setStatus(appInfo.getStatus()==1?9:1);
        System.out.println("=====after"+appInfoService.selectByPrimaryKey(appInfo.getId()).getStatus());
        appInfoService.updateByPrimaryKey(appInfo);
        return new UnivsJson().setStatus("ok").setInfo("操作成功") ;
    }
    @GetMapping("flatform/app/appinfoadd")
    public String appInfoAd(Model model,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        return "developer/appinfoadd";
    }
    @PostMapping("flatform/app/appinfoaddsave")
    public String appInfoSave(Model model,HttpServletRequest request){
        JSON json;
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        return "developer/appinfoadd";
    }
}