package com.xn.lmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/get")
    public String get() {
        return "Welcome using this test get method";
    }
}
