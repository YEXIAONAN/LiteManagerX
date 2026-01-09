package com.xn.lmx.Service;

import com.xn.lmx.Entity.User;
import com.xn.lmx.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {

        return userRepository.findByUserName(username)
                .filter(user -> user.getUserPassword().equals(password))
                .orElse(null);
    }
}
