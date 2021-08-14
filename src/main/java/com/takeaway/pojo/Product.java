package com.takeaway.pojo;



import java.math.BigDecimal;

public class Product {
    private String productid;
    private String category;
    private String cname;
    private String ename;
    private String image;
    private String descn;
    private BigDecimal listprice;
    private BigDecimal unitcost;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public BigDecimal getListprice() {
        return listprice;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productid + '\'' +
                ", category='" + category + '\'' +
                ", cname='" + cname + '\'' +
                ", ename='" + ename + '\'' +
                ", image='" + image + '\'' +
                ", descn='" + descn + '\'' +
                ", listprice=" + listprice +
                ", unitcost=" + unitcost +
                '}';
    }
}
