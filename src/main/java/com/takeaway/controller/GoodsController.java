package com.takeaway.controller;

import com.takeaway.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/showGoods",produces = "application/json;charset=utf-8")
    public Map showGoodsController(@RequestParam("goodsId") String goodsId){
        Integer id = Integer.valueOf(goodsId);
        Map<String,Object> map = new ConcurrentHashMap<>();
        return map;
    }
}
