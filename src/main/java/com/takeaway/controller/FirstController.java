package com.takeaway.controller;

import com.takeaway.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class FirstController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/loginAndRegister",produces = "text/html;charset=utf-8")
    public String LoginRegisterController(HttpSession session){
        String msg = "登录/注册";
        msg= (String) session.getAttribute("userNick");
        return "欢迎您! "+ msg;
    }
}
