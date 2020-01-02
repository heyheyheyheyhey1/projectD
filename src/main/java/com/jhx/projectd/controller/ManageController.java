package com.jhx.projectd.controller;

import com.jhx.projectd.entity.*;
import com.jhx.projectd.service.*;
import com.jhx.projectd.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @Autowired
    private DevUserService devUserService;

    @GetMapping("login")
    public String getAdminLogin() {
        return "backendlogin";
    }

    @PostMapping("dologin")
    public String verify(Model model, @RequestParam(value = "userCode", defaultValue = "") String userCode,
                         @RequestParam(value = "userPassword", defaultValue = "") String userPassword,
                         HttpServletRequest request) {
        System.out.println("管理员开始登陆！");
        List<AdminUser> adminUsers = adminUserService.selectByAdminUserAndPassword(userCode, userPassword);

        //if (session.getAttribute("adminId")== null) return "backendlogin";
        Iterator<AdminUser> u = adminUsers.iterator();
        while (u.hasNext()) {
            System.out.println(u.next().toString());
        }
        int checkUser = adminUsers.size();
        if (checkUser == 0) {
            System.out.println("false");
            model.addAttribute("error", "出问题了啊，检查一下！");
            return "backendlogin";
        } else {
            System.out.println("true");
            HttpSession session = request.getSession();
            session.setAttribute("adminId", adminUsers.get(0).getId());
            model.addAttribute("userSession", adminUsers.get(0));
            return "redirect:main";
        }

    }

    @GetMapping("logout")
    public String doLogin(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("adminId");
        model.addAttribute("result", "您已经成功退出登录！");
        return "200";
    }

    @GetMapping("main")
    public String getMain(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        else {
            Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
            List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
            model.addAttribute("userSession", adminUsers.get(0));
            return "backend/main";
        }
    }

    @GetMapping("backend/app/list")
    public String getAppList(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("开始进入backend/app/list！");
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppStatus> appStatuses = appStatusService.selectByValue2(2);
        model.addAttribute("userSession", adminUsers.get(0));
        model.addAttribute("statusList", appStatusService.selectByTypeCode(1));
        model.addAttribute("flatFormList", appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List", appCategoryService.selectByLevel(1));

        return "backend/applist";
    }

    @PostMapping("backend/app/list")
    public String appSearch(Model model, HttpServletRequest request, @RequestParam HashMap<String, String> pageInfo,
                            @RequestParam(value = "pageIndex", defaultValue = "1") int currentPageNo,
                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("============================================");
        System.out.println("开始查询未审核名单!");
        System.out.println(pageInfo.toString());
        pageInfo.put("queryStatusId", String.valueOf(2));
        List<HashMap<String, Object>> appListColumns = appInfoService.selectByParams(pageInfo);
        PageInfo<HashMap<String, Object>> pages = new PageInfo<>();
        pages.setList(sub(appListColumns, currentPageNo, pageSize));
        int totalCount = appListColumns.size();
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pages.setCurrentPageNo(currentPageNo);
        pages.setTotalPageCount(totalPageCount);
        pages.setTotalCount(totalCount);
        System.out.println("总页数" + totalPageCount);
        System.out.println("当前页是：" + currentPageNo);
        System.out.println("分页数据：");
        System.out.println(pages.getList());

        model.addAttribute("pages", pages);
        model.addAttribute("appInfoList", pages.getList());
        model.addAttribute("flatFormList", appStatusService.selectByTypeCode(2));
        model.addAttribute("categoryLevel1List", appCategoryService.selectByLevel(1));
        model.addAttribute("categoryLevel2List", appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel1Id") != null && pageInfo.get("queryCategoryLevel1Id") != "" ? Integer.parseInt(pageInfo.get("queryCategoryLevel1Id")) : 2));
        model.addAttribute("categoryLevel3List", appCategoryService.selectByParentId(pageInfo.get("queryCategoryLevel2Id") != null && pageInfo.get("queryCategoryLevel2Id") != "" ? Integer.parseInt(pageInfo.get("queryCategoryLevel2Id")) : 3));
        model.addAttribute("pageInfo", pageInfo);
        return "backend/applist";
    }

    public List<HashMap<String, Object>> sub(List<HashMap<String, Object>> s, int totalPageCount, int pageSize) {
        int start = (totalPageCount - 1) * pageSize;
        int end = start + pageSize < s.size() ? start + pageSize : s.size();
        return s.subList(start, end);
    }

    @GetMapping("backend/app/check")
    public String appCheck(Model model, HttpServletRequest request,
                           @RequestParam(value = "aid", defaultValue = "0") int aid,
                           @RequestParam(value = "vid", defaultValue = "0") int vid) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("============================================");
        System.out.println("开始审核!");
        System.out.println("aid is : " + aid + "。。。vid is : " + vid);
        session.setAttribute("aid", aid);
        session.setAttribute("vid", vid);
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());

        Map<String, String> pageInfo = new HashMap<>();
        pageInfo.put("queryAid", String.valueOf(aid));
        pageInfo.put("queryVid", String.valueOf(vid));
        List<HashMap<String, Object>> list = appInfoService.selectByParam2(pageInfo);
        System.out.println(list.toString());

        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppInfo> appInfos = appInfoService.selectByIdAndVersionId(aid,vid);
        List<AppVersion> appVersion = appVersionService.selectByVersionId(aid, vid);
        System.out.println(appVersion.toString());
        model.addAttribute("userSession", adminUsers.get(0));
        model.addAttribute("appInfo", list.get(0));
        model.addAttribute("appVersion", appVersion.get(0));

        return "backend/appcheck";
    }

    @PostMapping("backend/app/checksave")
    public String appCheckSave(Model model, @RequestParam(value = "status", defaultValue = "") String status,
                               HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("审核进行中！");
        System.out.println(status);
        Integer aid = Integer.parseInt(session.getAttribute("aid").toString());
        Integer vid = Integer.parseInt(session.getAttribute("vid").toString());
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
        //response.setContentType("text/html; charset=utf-8");
        //OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
        if (status.equals("3")) {
            int statusAfter = Integer.parseInt(status);
            int change = appInfoService.updateByAidAndVid(aid, vid, statusAfter);
            if (change == 0) {
                System.out.println(" Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核通过失败！");
                model.addAttribute("errorInfo", "数据审核通过失败！");
                return "403";
            }
            if (change == 1) {
                System.out.println(" Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核通过成功！");
                model.addAttribute("result", "数据审核通过成功！");
                return "200";
            }
        } else if (status.equals("13")) {
            int statusAfter = Integer.parseInt(status);
            int change = appInfoService.updateByAidAndVid(aid, vid, statusAfter);
            if (change == 0) {
                System.out.println("更新 Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核不通过失败！");
                model.addAttribute("errorInfo", "数据审核不通过失败！");
                return "403";
            }
            if (change == 1) {
                System.out.println("更新 Id 为：" + aid + "和 versionId 为：" + vid + "的数据审核不通过成功！");
                model.addAttribute("result", "数据审核不通过成功！");
                return "200";
            }
        }
        Map<String, String> pageInfo = new HashMap<>();
        pageInfo.put("queryAid", String.valueOf(aid));
        pageInfo.put("queryVid", String.valueOf(vid));
        List<HashMap<String, Object>> list = appInfoService.selectByParam2(pageInfo);
        System.out.println(list.toString());

        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppInfo> appInfos = appInfoService.selectByIdAndVersionId(aid,vid);
        List<AppVersion> appVersion = appVersionService.selectByVersionId(aid, vid);
        System.out.println(appVersion.toString());
        model.addAttribute("userSession", adminUsers.get(0));
        model.addAttribute("appInfo", list.get(0));
        model.addAttribute("appVersion", appVersion.get(0));

        return "backend/appcheck";
    }

    @ResponseBody
    @GetMapping("backend/app/categorylevellist.json")
    public List<AppCategory> getCategory(@RequestParam(value = "pid", defaultValue = "0") int pid) {
        return appCategoryService.selectByParentId(pid);
    }


    //===========================================用户管理==============================================================
    @GetMapping("backend/user/list")
    public String getUserList(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("开始进入backend/user/list！");
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
        //List<AppStatus> appStatuses = appStatusService.selectByValue2(2);
        model.addAttribute("userSession", adminUsers.get(0));
        return "backend/userlist";
    }


    @PostMapping("backend/user/list")
    public String userSearch(Model model, @RequestParam HashMap<String, String> pageInfo, HttpServletRequest request,
                             @RequestParam(value = "pageIndex", defaultValue = "1") int currentPageNo,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("开始进入backend/user/list！");
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
        System.out.println("============================================");
        System.out.println("开始查询未审核开发者名单!");
        System.out.println(pageInfo.toString());
        List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);

        pageInfo.put("queryStatusId", String.valueOf(21));
        List<HashMap<String, Object>> list = devUserService.selectByParam2(pageInfo);
        PageInfo<HashMap<String, Object>> pages = new PageInfo<>();
        pages.setList(sub(list, currentPageNo, pageSize));
        int totalCount = list.size();
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pages.setCurrentPageNo(currentPageNo);
        pages.setTotalPageCount(totalPageCount);
        pages.setTotalCount(totalCount);
        System.out.println("总页数" + totalPageCount);
        System.out.println("当前页是：" + currentPageNo);
        System.out.println("分页数据：");
        System.out.println(pages.getList());

        model.addAttribute("userSession", adminUsers.get(0));
        model.addAttribute("devTemp", pages.getList());
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pages", pages);
        return "backend/userlist";
    }

    @GetMapping("backend/user/usercheck")
    public String userCheck(Model model, HttpServletRequest request,
                            @RequestParam(value = "did", defaultValue = "0") int did) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("============================================");
        System.out.println("开始审核!");
        System.out.println("did is : " + did );
        session.setAttribute("did", did);
        Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());

            Map<String,String> pageInfo=new HashMap<>();
            pageInfo.put("queryDid",String.valueOf(did));
            List<HashMap<String,Object>> list=devUserService.selectByParam2(pageInfo);
            System.out.println(list.toString());

            List<AdminUser> adminUsers = adminUserService.selectByAdminId(adminId);
            model.addAttribute("userSession",adminUsers.get(0));
            model.addAttribute("devTemp",list.get(0));
            return "backend/usercheck";
    }
    @PostMapping("backend/user/checksave")
    public String userCheckSave(Model model, @RequestParam(value = "status", defaultValue = "") String status,
                               HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) return "redirect:/manager/login";
        System.out.println("审核进行中！");
        System.out.println(status);
        Integer did = Integer.parseInt(session.getAttribute("did").toString());
        if (status.equals("22")) {
            int statusAfter = Integer.parseInt(status);
            int change = devUserService.updateByDid(did,statusAfter);
            if (change == 0) {
                System.out.println(" 更新 Id 为：" + did  + "的数据审核通过失败！");
                model.addAttribute("errorInfo", "开发者审核通过失败！");
                return "403";
            }
            if (change == 1) {
                System.out.println(" 更新 Id 为：" + did  + "的数据审核通过成功！");
                model.addAttribute("result", "开发者审核通过成功！");
                return "200";
            }
        } else if (status.equals("23")) {
            int statusAfter = Integer.parseInt(status);
            int change = devUserService.updateByDid(did,statusAfter);
            if (change == 0) {
                System.out.println(" 更新 Id 为：" + did + "的数据审核不通过失败！");
                model.addAttribute("errorInfo", "开发者审核不通过失败！");
                return "403";
            }
            if (change == 1) {
                System.out.println(" 更新 Id 为：" + did + "的数据审核不通过成功！");
                model.addAttribute("result", "开发者审核不通过成功！");
                return "200";
            }
        }
        return "backend/userlist";
    }
}
