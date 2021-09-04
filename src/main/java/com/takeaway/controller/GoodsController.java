package com.takeaway.controller;

import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.exception.PageEnoughException;
import com.takeaway.pojo.Goods;
import com.takeaway.pojo.GoodsComment;
import com.takeaway.service.GoodsCommentService;
import com.takeaway.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCommentService goodsCommentService;

    @GetMapping(value = "/good",produces = "text/html;charset=utf-8")
    public ModelAndView GoodController(@RequestAttribute("goodsNo") String goodsNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsNo",goodsNo);
        modelAndView.setViewName("goods");
        return modelAndView;
    }

    @GetMapping(value = "/showGood",produces = "application/json;charset=utf-8")
    public Goods showGoodController(@RequestParam("goodsNo") String goodsNo) throws NoAsGoodsException {
        String[] no = {goodsNo};
        Goods good = new Goods();
        if (goodsService != null) {
            good = goodsService.findGoodsByGoodNo(no).get(0);
        }
        if (good == null){
            throw new NoAsGoodsException("没有该商品!");
        }
        return good;
    }

    @GetMapping(value = "/showGoodComment",produces = "application/json;charset=utf-8")
    public List<GoodsComment> showGoodComment(@RequestParam Map<String,String> message) throws PageEnoughException, NoAsGoodsException {
        List<GoodsComment> comments = new ArrayList<>();
        Integer page = Integer.valueOf(message.get("page"));
        String goodsNo = message.get("goodsNo");
        if (goodsNo != null && page != 0){
            if (goodsCommentService != null) {
                comments = goodsCommentService.findAllComments(goodsNo, page, 4);
            }
        }
        return comments;
    }

    @RequestMapping(value = "/pageCount")
    public String pageCount(@RequestParam("goodsNo") String goodsNo){
        String page = null;
        if (goodsCommentService != null){
            page = String.valueOf(goodsCommentService.findAllCommentByGoodsId(goodsNo));
        }
        return page;
    }
}
