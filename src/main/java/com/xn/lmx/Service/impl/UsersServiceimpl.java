package com.xn.lmx.Service.impl;

import com.xn.lmx.Entity.Users;
import com.xn.lmx.Mapper.UsersMapper;
import com.xn.lmx.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceimpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    // 实现业务层接口，重写业务层接口方法
    @Override
    public boolean login(String name,String password){
        Users users = usersMapper.login(name);

        if (users==null){
            // 如果用户名不存在
            return false;
        }else {
            // 用户名存在
            if (users.getUPassword().equals(password)){
                return true;
            }else {
                // 密码错误
                return false;
            }
        }
    }



}
