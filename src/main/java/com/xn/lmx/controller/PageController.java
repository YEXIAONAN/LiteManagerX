package com.xn.lmx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/test")
    public String User_test(HttpServletRequest request, Model model) {

        String user_name = "User";
        String ip = request.getRemoteAddr();

        model.addAttribute("user_name",user_name);
        model.addAttribute("user_ip",ip);

        return "testPage";
    }
}
