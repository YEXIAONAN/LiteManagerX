package com.xn.lmx.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import com.xn.lmx.Entity.User;
//import com.xn.lmx.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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



//    @Autowired
//    private UserService userService;
//
//    // 登录页
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    // 处理登录
//    @PostMapping("/login")
//    public String doLogin(
//            @RequestParam String username,
//            @RequestParam String password,
//            HttpSession session,
//            Model model
//    ) {
//        User user = userService.login(username, password);
//
//        if (user != null) {
//            session.setAttribute("loginUser", user);
//            return "redirect:/dashboard";
//        }
//
//        model.addAttribute("error", "用户名或密码错误");
//        return "login";
//    }
//
//    // 主页面
//    @GetMapping("/dashboard")
//    public String dashboard(HttpSession session) {
//
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser == null) {
//            return "redirect:/login";
//        }
//
//        return "main_dashboard";
//    }
}
