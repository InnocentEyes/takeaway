package com.takeaway.controller;

import com.takeaway.exception.NotEnoughtException;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Member;
import com.takeaway.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @ResponseBody
    @PostMapping(value = "/login",produces = "text/html;charset=utf-8")
    public String Login(Member member){
        String msg = "index";
        if (member.getId().equals("") || member.getId() == null){
            throw new NotEnoughtException("用户无ID!");
        }
        if (member.getPassword().equals("") || member.getPassword() == null){
            throw new NotEnoughtException("用户未输入密码");
        }

        Member members = memberService.queryById(member.getId(), member.getPassword());
        if (members != null){
            msg = "first";
        }
        return msg;
    }

    @PostMapping (value = "/register")
    public String Register(@RequestParam Map<String,String> member){
        boolean flag = false;
        String msg = "index";
        if (member.get("userName").equals("") || member.get("userEmail").equals("") || member.get("userPassword").equals("")){
            throw new NotEnoughtException("用户信息缺失!");
        }else {
            flag = memberService.signinMember(member);
        }
        if (flag == true){
            msg = "first";
        }
        return msg;
    }
}
