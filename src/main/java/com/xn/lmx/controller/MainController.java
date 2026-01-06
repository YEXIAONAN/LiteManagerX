package com.xn.lmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

//    // Index 项目介绍页面
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






    // ------------

    // 测试路由
    @GetMapping("/test")
    public String ping() {
        return "you can connect the services";
    }
}
