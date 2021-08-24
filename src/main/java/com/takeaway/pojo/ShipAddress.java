package com.takeaway.pojo;

/**
 * 地址类
 */
public class ShipAddress {
    private Integer id;
    private Integer memberId;
    private Member member;
    private String name;
    private Integer areaId;
    private ShipArea shipArea;
    private String address;
    private String zipcode;
    private String telno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public ShipArea getShipArea() {
        return shipArea;
    }

    public void setShipArea(ShipArea shipArea) {
        this.shipArea = shipArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    @Override
    public String toString() {
        return "ShipAddress{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", member=" + member +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                ", shipArea=" + shipArea +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", telno='" + telno + '\'' +
                '}';
    }
}
