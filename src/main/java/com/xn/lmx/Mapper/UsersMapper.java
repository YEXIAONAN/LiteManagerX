package com.xn.lmx.Mapper;

import com.xn.lmx.Entity.Users;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper {
    // Login Method
    public abstract Users login(String name);
}
