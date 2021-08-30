package com.takeaway.controller;

import com.takeaway.exception.NotEnoughtException;
import com.takeaway.pojo.Member;
import com.takeaway.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author qzlzzz
 * 该控制器是做用户的登录和注册功能
 */

@Controller
public class IndexController {

    @Autowired
    private MemberService memberService;

    /**
     * 登录处理器方法
     * @param member 用户的ID 密码
     * @return 登录成功跳转到首页 不成功则返回首页
     */
    @PostMapping(value = "/login",produces = "text/html;charset=utf-8")
    public String Login(Member member, HttpSession session){
        String msg = "index";
        if (member.getNick().equals("") || member.getNick() == null){
            throw new NotEnoughtException("用户无账户名!");
        }
        if (member.getPassword().equals("") || member.getPassword() == null){
            throw new NotEnoughtException("用户未输入密码");
        }

        Member user = memberService.login(member.getNick(), member.getPassword());
        if (user != null){
            /*
                session默认为30分钟
             */
            session.setAttribute("userId",user.getId());
            session.setAttribute("userLayerId",user.getLayerid());
            session.setAttribute("userNick",user.getNick());
            session.setAttribute("userCredit",user.getCredit());
            return "first";
        }
        return msg;
    }

    /**
     * 注册方法
     * @param member 用户信息
     * @return 与登陆一致
     */
    @PostMapping (value = "/register")
    public String Register(@RequestParam Map<String,String> member,HttpSession session){
        Member user = null;
        String msg = "index";
        if (member.get("nick").equals("") || member.get("email").equals("") || member.get("password").equals("")){
            throw new NotEnoughtException("用户信息缺失!");
        }else {
            user = memberService.register(member);

        }
        /*
            session的默认为30分钟
         */
        if (user != null){
            session.setAttribute("userId",user.getId());
            session.setAttribute("userLayerId",user.getLayerid());
            session.setAttribute("userNick",user.getNick());
            session.setAttribute("userCredit",user.getCredit());
            msg = "first";
        }
        return msg;
    }
}
