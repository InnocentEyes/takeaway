package com.takeaway.pojo;

/**
 * 送货区域
 */
public class ShipArea {
    private Integer id;
    private String area;
    private Float cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "ShipArea{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
