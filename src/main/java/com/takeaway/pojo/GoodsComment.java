package com.takeaway.pojo;

/**
 * 商品评论
 */
public class GoodsComment {
    private Integer id;
    private Integer memberid;
    private Member member;
    private String goodsNo;
    private Goods goods;
    private String pubTime;
    private Integer score;
    private String desc;


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

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GoodsComment{" +
                "id=" + id +
                ", memberid=" + memberid +
                ", member=" + member +
                ", goodsNo='" + goodsNo + '\'' +
                ", goods=" + goods +
                ", pubTime='" + pubTime + '\'' +
                ", score=" + score +
                ", desc='" + desc + '\'' +
                '}';
    }
}
