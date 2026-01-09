package com.xn.lmx.controller;

import com.xn.lmx.Entity.User;
import com.xn.lmx.Repository.UserRepository;
import com.xn.lmx.Util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户名不存在"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }

        String token = JwtUtil.generateToken(user.getId());

        return Map.of("token", token);
    }
}
