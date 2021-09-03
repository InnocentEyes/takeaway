package com.takeaway.controller;

import com.takeaway.pojo.Goods;
import com.takeaway.service.GoodsService;
import com.takeaway.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class FirstController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/loginAndRegister",produces = "text/html;charset=utf-8")
    public String LoginRegisterController(HttpSession session){
        String msg = "";
        msg = (String) session.getAttribute("userNick");
        if (msg == null){
            msg = "登录/注册";
        }else {
            msg = "欢迎您! "+msg;
        }
        return msg;
    }

    @GetMapping(value = "/findByNo",produces = "application/json;charset=utf-8")
    public List<Goods> findByTypeNoController(@RequestParam("typeNo") String typeNo){
        List<Goods> goods = new ArrayList<>();
        if (typeNo != null){
            goods = goodsService.findGoodsByTypeNo(typeNo);
        }
        return goods;
    }
}
