package com.takeaway.pojo;

import java.util.List;

/**
 * 商品列表 (存在疑问)
 */
public class GoodType {
    private Integer id;
    private String no;
    private String name;
    private String parantType;
    private GoodType parent;
    private String des;
    private String img;
    private List<GoodType> childType;


    public List<GoodType> getChildType() {
        return childType;
    }

    public void setChildType(List<GoodType> childType) {
        this.childType = childType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParantType() {
        return parantType;
    }

    public void setParantType(String parantType) {
        this.parantType = parantType;
    }

    public GoodType getParent() {
        return parent;
    }

    public void setParent(GoodType parent) {
        this.parent = parent;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "GoodType{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", parantType='" + parantType + '\'' +
                ", parent=" + parent +
                ", des='" + des + '\'' +
                ", img='" + img + '\'' +
                ", childType=" + childType +
                '}';
    }
}
