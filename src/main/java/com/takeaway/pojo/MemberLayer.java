package com.takeaway.pojo;

/**
 * 会员级别
 */
public class MemberLayer {
    private Integer id;
    private String layer;
    private Integer minCredit;
    private Float creditScale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Integer getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(Integer minCredit) {
        this.minCredit = minCredit;
    }

    public Float getCreditScale() {
        return creditScale;
    }

    public void setCreditScale(Float creditScale) {
        this.creditScale = creditScale;
    }

    @Override
    public String toString() {
        return "MemberLayer{" +
                "id=" + id +
                ", layer='" + layer + '\'' +
                ", minCredit=" + minCredit +
                ", creditScale=" + creditScale +
                '}';
    }
}
