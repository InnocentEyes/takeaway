package com.takeaway.pojo;

/**
 * 商品清单
 */
public class OrderDetail {
    private Integer id;
    private String goodsNo;
    private String goodsName;
    private String orderNo;
    private Float price;
    private Float discount;
    private Float memberPrice;
    private Integer qty;
    private Float allPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Float memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Float getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Float allPrice) {
        this.allPrice = allPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", goodsNo='" + goodsNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", memberPrice=" + memberPrice +
                ", qty=" + qty +
                ", allPrice=" + allPrice +
                '}';
    }
}
