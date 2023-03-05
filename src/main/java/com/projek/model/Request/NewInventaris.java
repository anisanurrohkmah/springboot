package com.projek.model.Request;

public class NewInventaris {

    String name;
    Integer price;
    String brand;



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
