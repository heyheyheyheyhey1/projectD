package com.jhx.projectd.configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class  LoginIntercpt implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session=request.getSession();
        if (session.getAttribute("devId")==null&&session.getAttribute("adminId")==null){
            System.out.println("未登录的访问!拒绝!");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
