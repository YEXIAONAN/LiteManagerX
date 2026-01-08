package com.xn.lmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index_main() {
        return "index";
    }

    @GetMapping("/LiteCloud")
    public String LiteCloud() {
        return "LiteCloud";
    }

    @GetMapping("/DataBaseSearch")
    public String DataBaseSearch() {
        return "DataBaseSearch";
    }

    @GetMapping("/test")
    public String test() {
        return "testPage";
    }
}
