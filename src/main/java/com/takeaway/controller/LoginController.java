package com.takeaway.controller;

import com.takeaway.exception.NotEnoughtException;
import com.takeaway.pojo.Member;
import com.takeaway.service.MemberService;
import com.takeaway.util.BASE64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author qzlzzz
 * 该控制器是做用户的登录和注册功能
 */

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    /**
     * 登录处理器方法
     * @param member 用户的ID 密码
     * @return 登录成功跳转到首页 不成功则返回首页
     */
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

        Member members = memberService.queryById(member.getId(), BASE64.encode(member.getPassword()));
        if (members != null){
            msg = "first";
        }
        return msg;
    }

    /**
     * 注册方法
     * @param member 用户信息
     * @return 与登陆一致
     */
    @PostMapping (value = "/register")
    public String Register(@RequestParam Map<String,String> member){
        boolean flag = false;
        String msg = "index";
        if (member.get("userName").equals("") || member.get("userEmail").equals("") || member.get("userPassword").equals("")){
            throw new NotEnoughtException("用户信息缺失!");
        }else {
            String userPassword = BASE64.encode(member.get("userPassword"));
            member.put("userPassword",userPassword);
            flag = memberService.signinMember(member);
        }
        if (flag == true){
            msg = "first";
        }
        return msg;
    }
}
