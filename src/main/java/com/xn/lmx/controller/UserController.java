package com.xn.lmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @GetMapping("/user/info")
    public String info(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return "当前登录用户：" + username;
    }
}
