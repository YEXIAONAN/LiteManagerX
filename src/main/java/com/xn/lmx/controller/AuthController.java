package com.xn.lmx.controller;

import com.xn.lmx.model.LoginRequest;
import com.xn.lmx.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        // 这里只是演示，真实项目查数据库
        if (!"admin".equals(request.getUsername())
                || !"123456".equals(request.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        String token = JwtUtil.generateToken(request.getUsername());

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("type", "Bearer");

        return result;
    }
}
