package com.howtodoinjava.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    private Integer uid;
    private String mail;
    private String password;
    private Long mobileno;
    private String city;
    private Long adharacard;
    private Long accountno;
    private String name;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileno() {
        return mobileno;
    }

    public void setMobileno(Long mobileno) {
        this.mobileno = mobileno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getAdharacard() {
        return adharacard;
    }

    public void setAdharacard(Long adharacard) {
        this.adharacard = adharacard;
    }

    public Long getAccountno() {
        return accountno;
    }

    public void setAccountno(Long accountno) {
        this.accountno = accountno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}