package com.example.finalexam2020roneetkumar.model;

import java.io.Serializable;

//RONEET KUMAR

public class Client implements Serializable {

    private String cid;
    private String name;
    private String city;
    private Double subTotal;
    private String clientType;
    private Double total;

    public Client(String cid, String name, String city, Double subTotal, String clientType) {
        this.cid = cid;
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);;
        this.city = city;
        this.subTotal = subTotal;
        this.clientType = clientType;
        this.total =  subTotal + (subTotal * 1.15);
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

}
