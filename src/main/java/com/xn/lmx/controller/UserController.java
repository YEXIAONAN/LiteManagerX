package com.xn.lmx.controller;

import com.xn.lmx.Dto.UserDTO;
import com.xn.lmx.Entity.User;
import com.xn.lmx.Repository.UserRepository;
import com.xn.lmx.Util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public UserDTO getCurrentUser(@RequestHeader("Authorization") String token) {
        Long userId = JwtUtil.parseToken(token);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}
