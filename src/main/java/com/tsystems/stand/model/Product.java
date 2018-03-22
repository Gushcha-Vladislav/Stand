package com.tsystems.stand.model;

public class Product {


    private int id;

    private String name;

    private int price;

    private String image;

    private int numberOfSales;

    public Product() {
    }

    public Product(int id, String name, int price, String image, int numberOfSales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.numberOfSales = numberOfSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }
}
