package com.jhx.projectd.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping("/")
    public String getIndex(){
        System.out.println("============");
        return "index";
    }
}
