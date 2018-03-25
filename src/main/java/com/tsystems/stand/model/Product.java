package com.tsystems.stand.model;

public class Product {


    private int id;

    private String nameProduct;

    private int price;

    private String image;

    private int numberOfSales;

    public Product() {
    }

    public Product(int id, String nameProduct, int price, String image, int numberOfSales) {
        this.id = id;
        this.nameProduct = nameProduct;
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

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name) {
        this.nameProduct = nameProduct;
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
