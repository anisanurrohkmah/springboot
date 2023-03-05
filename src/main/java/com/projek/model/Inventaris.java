package com.projek.model;


public class Inventaris {


    String idInventory;
    String name;
    Integer price;
    String brand;

    public Inventaris(String idInventory, String name, Integer price, String brand) {
        this.idInventory = idInventory;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(String idInventory) {
        this.idInventory = idInventory;
    }

    @Override
    public String toString() {
        return "Inventaris{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", merk='" + brand + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMerk() {
        return brand;
    }

    public void setMerk(String merk) {
        this.brand = brand;
    }
}
