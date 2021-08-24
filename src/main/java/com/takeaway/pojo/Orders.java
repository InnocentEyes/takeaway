package com.takeaway.pojo;

import java.util.List;

/**
 * 订单
 */
public class Orders {
    private Integer no;
    private String name;
    private Integer type;
    private Member member;
    private Integer credit;
    private Integer shipAddressId;
    private ShipAddress shipAddress;
    private String shipType;
    private Dict shipTypeDict;
    private String payType;
    private Dict payTypeDict;
    private String orderTime;
    private Float amount;
    private Integer creditUsed;
    private Integer status;
    private Integer handle;
    private List<OrderDetail> orderDetails;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Integer shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public ShipAddress getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(ShipAddress shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Dict getShipTypeDict() {
        return shipTypeDict;
    }

    public void setShipTypeDict(Dict shipTypeDict) {
        this.shipTypeDict = shipTypeDict;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Dict getPayTypeDict() {
        return payTypeDict;
    }

    public void setPayTypeDict(Dict payTypeDict) {
        this.payTypeDict = payTypeDict;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(Integer creditUsed) {
        this.creditUsed = creditUsed;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHandle() {
        return handle;
    }

    public void setHandle(Integer handle) {
        this.handle = handle;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", member=" + member +
                ", credit=" + credit +
                ", shipAddressId=" + shipAddressId +
                ", shipAddress=" + shipAddress +
                ", shipType='" + shipType + '\'' +
                ", shipTypeDict=" + shipTypeDict +
                ", payType='" + payType + '\'' +
                ", payTypeDict=" + payTypeDict +
                ", orderTime='" + orderTime + '\'' +
                ", amount=" + amount +
                ", creditUsed=" + creditUsed +
                ", status=" + status +
                ", handle=" + handle +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
