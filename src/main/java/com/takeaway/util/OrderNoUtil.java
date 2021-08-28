package com.takeaway.util;

import java.util.Random;

public class OrderNoUtil {

    /***
     * 生成订单号 8位数字
     */
    public static String generateUID(){
        Random random = new Random();
        String result="";
        for(int i=0;i<8;i++){
            //首字母不能为0
            result += (random.nextInt(9)+1);
        }
        return result;
    }
}
