package com.takeaway.pojo;

/**
 * 收藏夹
 */
public class Collect {
    private Integer id;
    private Integer memberid;
    private Member member;
    private String goodsNo;
    private Goods goods;
    private String colTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getColTime() {
        return colTime;
    }

    public void setColTime(String colTime) {
        this.colTime = colTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", memberid=" + memberid +
                ", member=" + member +
                ", goodsNo='" + goodsNo + '\'' +
                ", goods=" + goods +
                ", colTime='" + colTime + '\'' +
                '}';
    }
}
