package com.takeaway.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productid;
    private String category;
    private String cname;
    private String ename;
    private String image;
    private String descn;
    private BigDecimal listprice;
    private BigDecimal unitcost;
}
