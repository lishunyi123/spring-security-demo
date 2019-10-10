package com.lishunyi.securityloginmemory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HomeController
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/10 17:33
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/10 17:33
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Controller
public class HomeController {

    @GetMapping({"/", "/index", "/home"})
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
