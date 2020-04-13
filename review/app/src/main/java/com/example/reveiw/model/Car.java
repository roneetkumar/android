package com.example.reveiw.model;

import java.io.Serializable;

public class Car implements Serializable {

    private String id;
    private String brand;
    private String model;
    private Double price;
    private Integer year;

    public Car(String brand, String id, String model, Double price, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
