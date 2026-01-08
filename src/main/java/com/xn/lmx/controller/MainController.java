package com.xn.lmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xn.lmx.controller.Infomation;

import java.util.Scanner;

@RestController
public class MainController {








    // ------------

    // 测试返回信息
    @GetMapping("/getGeneralInfomation")
    public static String Info() {
        Scanner sc = new Scanner(System.in);
        String User_Input = sc.nextLine();
        return "Please enter a string.";
    }

    // 测试路由
    @GetMapping("/test")
    public String ping() {
        return "you can connect the services";
    }

    // Index 项目介绍页面
//    @GetMapping("/")
//    public String index() {
//        return "index.html";
//    }
//
//    @GetMapping("/index")
//    public String Mainindex() {
//        return "index.html";
//    }
//
//    // 数据库自查寻页面
//    @GetMapping("/DataBaseSearch")
//    public String DataBaseSearch() {
//        return "DataBaseSearch.html";
//    }
}
