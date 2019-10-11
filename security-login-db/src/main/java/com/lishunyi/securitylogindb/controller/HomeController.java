package com.lishunyi.securitylogindb.controller;

import com.lishunyi.securitylogindb.entity.User;
import com.lishunyi.securitylogindb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName HomeController
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/11 17:24
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/11 17:24
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User user) {
        userService.insert(user);
        return "redirect:register?success";
    }
}
