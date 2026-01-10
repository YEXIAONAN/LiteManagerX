package com.xn.lmx.Controller;

import com.xn.lmx.Service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping("/login")
    public String login(String name,String password) {
        // 调用业务层代码
        boolean login = usersService.login(name,password);
        if (login){
            return "login";
        }else {
            return "success";
        }
    }
}
