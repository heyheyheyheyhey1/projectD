package com.jhx.projectd.controller;
import com.jhx.projectd.entity.*;
import com.jhx.projectd.service.*;
import com.jhx.projectd.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    AppVersionService appVersionService;
    @Autowired
    DevApplyService devApplyService ;



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

    @GetMapping("create")
    public String create(){
        return "developer/create";
    }

    @PostMapping("create")
    public String create_post(Model model,@RequestParam HashMap<String,String> params){
        String devName = params.get("devName");
        String devPassword = params.get("devPassword");
        String devEmail = params.get("devEmail");
        Integer devCode = Integer.parseInt(params.get("devCode"));
        if (devCode==null){
            model.addAttribute("error","没有填写开发者编码");
            return "developer/create";
        }
        DevUser devUser=devUserService.selectByDevCode(devCode);
        if (devUser!=null){
            model.addAttribute("error","开发者编码已经被用过了!!!!!");
            return "developer/create";
        }
        devUser=new DevUser();
        devUser.setDevCode(devCode);
        devUser.setDevEmail(devEmail);
        devUser.setDevName(devName);
        devUser.setDevPassword(devPassword);
        devUserService.insert(devUser);
        DevApply devApply = new DevApply();
        devApply.setDevId(devUserService.selectByDevCode(devCode).getId());
        devApply.setApplyInfo("系统自动生成");
        devApply.setStatus(21);
        devApplyService.insert(devApply);
        model.addAttribute("error","创建成功!");
        return "developer/create";
    }

    @GetMapping("logout")
    public String doLogin(Model model, HttpServletRequest request){
        request.getSession().removeAttribute("devId");
        model.addAttribute("result","您已经成功退出登录！");
        return "200";
    }

    @GetMapping("flatform/app/main")
    public String devMain(Model model,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null) {
            System.out.println("没找到啊");
            return "/";
        }
        model.addAttribute("devUserSession",devUser);
        System.out.println("登录用户的状态为 ===  "+devUser.getStatus());
        return "developer/main";


    }

    @GetMapping("flatform/app/devApply")
    public String requestDev(Model model,HttpServletRequest request){
        model.addAttribute("devUserSession",devUserService.selectByIdFromSession(request.getSession()));
        return "developer/apply";
    }
    @PostMapping("flatform/app/devApply")
    public String devApply(Model model,@RequestParam String applyInfo,HttpServletRequest request){
        DevUser devUser =devUserService.selectByIdFromSession(request.getSession());
        if (devUser.getStatus()!=23){
            model.addAttribute("errorInfo","您的申请正在被审核或者您已经是开发者");
            return "403";
        }
        DevApply apply = new DevApply();
        devUser.setStatus(AppStatus.STATUS_WAITING_REVIEW);
        apply.setStatus(AppStatus.STATUS_WAITING_REVIEW);
        apply.setDevId(devUser.getId());
        apply.setApplyInfo(applyInfo.trim());
        devApplyService.insert(apply);
        devUserService.updateByPrimaryKey(devUser);
        return "200";
    }
    @GetMapping("flatform/app/list")
    public String devAppList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null||devUser.getStatus()!=AppStatus.STATUS_PERMITTED) {
            model.addAttribute("errorInfo","你没有权限!");
            return "403";
        }
        model.addAttribute("devUserSession",devUser);
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        return "developer/appinfolist";
    }

    @PostMapping("flatform/app/list")
    public String getAappList(Model model, @RequestParam HashMap <String ,String> pageInfo,HttpServletRequest request,
                              @RequestParam(value = "pageIndex",defaultValue = "1")int currentPageNo,
                              @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        System.out.println(pageInfo.toString());
        if (devUser==null) return "redirect:/";
        pageInfo.put("devId",String.valueOf(devUser.getId()));


        List<HashMap<String,Object>> list=appInfoService.selectByParams(pageInfo);
        PageInfo<HashMap<String,Object>> pages = new PageInfo<>();
        pages.setList(sub(list,currentPageNo,pageSize));
        int totalCount = list.size();
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pages.setCurrentPageNo(currentPageNo);
        pages.setTotalPageCount(totalPageCount);
        pages.setTotalCount(totalCount);
        System.out.println("总页数" + totalPageCount);
        System.out.println("当前页是：" + currentPageNo);
        System.out.println("分页数据：");
        System.out.println(pages.getList());


        if (list.size()!=0){
            System.out.println(list.size());
        }

        model.addAttribute("pages",pages);
        model.addAttribute("appInfoList",pages.getList());
        model.addAttribute("pageInfo",pageInfo);

        model.addAttribute("devUserSession",devUser);
        model.addAttribute("statusList",appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList",appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List",appCategoryService.selectByLevel(1));
        model.addAttribute("categoryLevel2List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel1Id")!=null&&pageInfo.get("queryCategoryLevel1Id")!=""?Integer.parseInt(pageInfo.get("queryCategoryLevel1Id")):2));
        model.addAttribute("categoryLevel3List",appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel2Id")!=null&&pageInfo.get("queryCategoryLevel2Id")!=""?Integer.parseInt(pageInfo.get("queryCategoryLevel2Id")):3));


        return "developer/appinfolist";
    }
    public List<HashMap<String,Object>> sub(List<HashMap<String,Object>> s,int totalPageCount,int pageSize){
        int start=(totalPageCount-1)*pageSize;
        int end=start+pageSize <s.size()?start+pageSize:s.size();
        return s.subList(start,end);
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
    public Map<String,Object> saleSwitch(HttpServletRequest request,HttpServletResponse response,@RequestParam("appId")Integer appId,@RequestParam("versionId")Integer versionId){
        DevUser devUser=devUserService.selectByIdFromSession(request.getSession());
        AppInfo appInfo = appInfoService.selectByPrimaryKey(appId);
        AppVersion appVersion=appVersionService.selectByPrimaryKey(versionId);
        Map<String,Object> map=new HashMap<>();

        if (appVersion==null||appInfo==null||appInfo.getDevId()!=devUser.getId()){
            response.setStatus(403);
            map.put("status","false");
            map.put("info","没这个爱啪啪或者爱啪啪开发者与当前开发者不对应");
            return map;
        }

        System.out.println("===before"+appInfo.getStatus());
        appInfo.setStatus(appInfo.getStatus()==1?9:1);
        appVersion.setPublishStatus(appVersion.getPublishStatus()==AppStatus.APP_STATUS_ON_SALE?AppStatus.APP_STATUS_NOT_PERMITTED:AppStatus.APP_STATUS_ON_SALE);

        System.out.println("=====after"+appInfoService.selectByPrimaryKey(appInfo.getId()).getStatus());
        appVersionService.updateByPrimaryKey(appVersion);
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
            model.addAttribute("errorInfo","你没有上传图片文件嗷");
            return "403";
        }
        if (appInfoService.selectByAPKName(pageInfo.getAPKName()).size()!=0){
            model.addAttribute("errorInfo","注意APKName嗷");
            return "403";
        }

        System.out.println("文件大小"+pageInfo.getA_logoPicPath().getSize());
        String downloadPath = UploadFileUtils.saveUploadfile(pageInfo.getA_logoPicPath());
        appInfoService.insert(new AppInfo(pageInfo,downloadPath));
        model.addAttribute("result","上传完成了嗷");

        return "200";
    }

    @GetMapping("flatform/app/appversionadd")
    public String addVersion(Model model,@RequestParam("id")Integer appId,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        model.addAttribute("appVersionList",appVersionService.selectFullInfoByAppId(appId));
        model.addAttribute("appId",appId);
        return "developer/appversionadd";
    }

    @PostMapping("flatform/app/appversionadd")
    public String addVersionSave(Model model, @ModelAttribute AddAppVersionPageInfo pageInfo, HttpServletRequest request) throws IOException {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        System.out.println("文件大小"+pageInfo.getA_downloadLink().getSize());
        System.out.println("页面属性"+pageInfo.toString());
        String downloadLink=UploadFileUtils.saveUploadfile(pageInfo.getA_downloadLink());
        System.out.println("文件绝对路径"+downloadLink);
        appVersionService.insert(new AppVersion(pageInfo,downloadLink));
        model.addAttribute("devUserSession",devUser);
        model.addAttribute("appVersionList",appVersionService.selectFullInfoByAppId(pageInfo.getAppId()));
        model.addAttribute("result","添加版本成功!");
        model.addAttribute("appId",pageInfo.getAppId());
        List<HashMap<String,Object>>list = appVersionService.selectFullInfoByAppId(pageInfo.getAppId());
        appInfoService.updateVersionIdByAppId(pageInfo.getAppId(),(Integer) list.get(0).get("id"));
        appInfoService.updateStatusByAppId(pageInfo.getAppId(),AppStatus.APP_STATUS_WAITING_REVIEW);
        return "200";
    }
    @PostMapping("flatform/app/appversionmodifysave")
    public String addVersionModifySave(Model model, @ModelAttribute AddAppVersionPageInfo pageInfo, HttpServletRequest request) throws IOException {
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        System.out.println("文件大小"+pageInfo.getA_downloadLink().getSize());
        System.out.println("页面属性"+pageInfo.toString());
        String downloadLink=null;
        AppVersion version = appVersionService.selectByPrimaryKey(pageInfo.getId());

        if (pageInfo.getA_downloadLink().getSize()!=0){
            downloadLink=UploadFileUtils.saveUploadfile(pageInfo.getA_downloadLink());
        }
        version.updateAppVersion(pageInfo,downloadLink);
        appVersionService.updateByPrimaryKey(version);
        model.addAttribute("appVersionList",appVersionService.selectFullInfoByAppId(pageInfo.getAppId()));
        model.addAttribute("appId",pageInfo.getAppId());
        model.addAttribute("result","修改成功!");
        List<HashMap<String,Object>>list = appVersionService.selectFullInfoByAppId(pageInfo.getAppId());
        return "200";
    }


    @RequestMapping("flatform/app/appversionmodify")
    public String versioModify(Model model,@RequestParam()HashMap<String,String> map,HttpServletRequest request){
        DevUser devUser =devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        int appId=Integer.parseInt(map.get("aid"));
        List <HashMap<String,Object>> list =appVersionService.selectFullInfoByAppId(appId);
        if (list.size()==0){
            model.addAttribute("errorInfo","错误的访问");
            return "403";
        }
        model.addAttribute("appVersionList",list);
        model.addAttribute("appVersion",list.get(0));
        return "developer/appversionmodify";
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

    @RequestMapping("flatform/app/appview")
    public String viewApp(Model model,@RequestParam("appId")Integer id,HttpServletRequest request){
        DevUser devUser =devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        Map map= new HashMap();
        map.put("id",id);
        List <HashMap<String,String>> list = appInfoService.selectByParams(map);
        if(list.size()!=0){
            model.addAttribute("appInfo",list.get(0));
        }
        else {
            return "403";
        }
        model.addAttribute("appVersionList",appVersionService.selectFullInfoByAppId(id));

        return "developer/appinfoview";
    }
    @RequestMapping("flatform/app/appinfomodify")
    public String appModify(Model model,@RequestParam("appId")Integer id,HttpServletRequest request){
        DevUser devUser =devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        Map map= new HashMap();
        map.put("id",id);
        List <HashMap<String,String>> list = appInfoService.selectByParams(map);
        if(list.size()!=0){
            model.addAttribute("appInfo",list.get(0));
        }
        else {
            return "403";
        }
        return "developer/appinfomodify";
    }
    @RequestMapping("flatform/app/appinfomodifysave")
    public String appModifySave(Model model, @ModelAttribute AddNewAppPageInfo pageInfo, HttpServletRequest request) throws IOException{
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        model.addAttribute("devUserSession",devUser);
        MultipartFile multipartFile = pageInfo.getA_logoPicPath();
        System.out.println(multipartFile.getSize());
        if (multipartFile.getSize()!=0&&!UploadFileUtils.isImage(pageInfo.getA_logoPicPath())) {
            model.addAttribute("errorInfo","你没有上传图片文件或者上传的不是图片文件嗷");
            return "403";
        }
        System.out.println("文件大小"+pageInfo.getA_logoPicPath().getSize());
        String downloadPath=null;
        if (multipartFile.getSize()!=0){
            downloadPath = UploadFileUtils.saveUploadfile(pageInfo.getA_logoPicPath());
        }
        AppInfo newApp =new AppInfo(pageInfo,downloadPath);
        newApp.setDevId(devUser.getId());
        newApp.setId(pageInfo.getAppId());
        appInfoService.updateByPrimaryKey(newApp);
        model.addAttribute("result","上传完成了嗷");

        return "200";
    }



    @ResponseBody
    @RequestMapping("flatform/app/delimg")
    public Map<String,String> delImg(@RequestParam("id")Integer id){
        Map <String,String> map = new HashMap<>();
        AppInfo appInfo = appInfoService.selectByPrimaryKey(id);
        if (appInfo==null||appInfo.getDevId()!=id){
            map.put("status","failed");
            map.put("info","没这app或者你不是这个app与开发者不对应");
        }
        appInfo.setLogoPicPath("");
        appInfo.setLogoLocPath("");
        appInfoService.updateByPrimaryKey(appInfo);
        map.put("status","ok");
        map.put("info","");
        return map;
    }
    @ResponseBody
    @RequestMapping("flatform/app/delfile")
    public Map<String,String> delFile(@RequestParam("versionId")Integer id){
        Map <String,String> map = new HashMap<>();
        AppVersion version = appVersionService.selectByPrimaryKey(id);
        System.out.println("version   "+id);
        if (version==null){
            map.put("status","failed");
            map.put("info","没这app或者你不是这个app与开发者不对应");
            return map;
        }
        version.setDownloadLink("");
        appVersionService.updateByPrimaryKey(version);
        map.put("status","ok");
        map.put("info","");
        return map;
    }


    @GetMapping("devInfoChange")
    public String devInfoChange(Model model,@RequestParam HashMap <String,String> map,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null){
            model.addAttribute("errorInfo","没有权限的访问!");
            return "403";
        }
        model.addAttribute("devUserSession",devUser);
        return "developer/devInfoChange";

    }
    @PostMapping("devInfoChange")
    public String devInfoChangeSave(Model model,@RequestParam HashMap <String,String> map,HttpServletRequest request){
        DevUser devUser = devUserService.selectByIdFromSession(request.getSession());
        if (devUser==null){
            model.addAttribute("errorInfo","没有权限的访问!");
            return "403";
        }
        devUserService.updateDevInfo(map);

        model.addAttribute("result","已经更新信息");
        return "200";

    }
}