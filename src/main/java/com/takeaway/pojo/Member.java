package com.takeaway.pojo;

import java.util.Date;

public class Member {
    private Integer id;
    private String email;
    private String nick;
    private String password;
    private Integer credit;
    private Integer layerid;
    private Date rDatetime;

    public Member() {
    }

    public Member(Integer id, String email, String nick, String password, Integer credit, Integer layerid, Date rDatetime) {
        this.id = id;
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.credit = credit;
        this.layerid = layerid;
        this.rDatetime = rDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getLayerid() {
        return layerid;
    }

    public void setLayerid(Integer layerid) {
        this.layerid = layerid;
    }

    public Date getrDatetime() {
        return rDatetime;
    }

    public void setrDatetime(Date rDatetime) {
        this.rDatetime = rDatetime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", credit=" + credit +
                ", layerid=" + layerid +
                ", rDatetime=" + rDatetime +
                '}';
    }
}
