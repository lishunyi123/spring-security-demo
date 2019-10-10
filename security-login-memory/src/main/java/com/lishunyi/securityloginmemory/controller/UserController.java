package com.lishunyi.securityloginmemory.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @ClassName UserController
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/10 17:35
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/10 17:35
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user/user";
    }
}
