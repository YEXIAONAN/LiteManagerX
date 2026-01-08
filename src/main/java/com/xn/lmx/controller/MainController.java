package com.xn.lmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    // 测试路由
    @GetMapping("/TestConnect")
    public String ping() {
        return "you can connect the services";
    }
}
