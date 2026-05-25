package com.java.app;

public class Product {

    String farmerName;
    String productName;
    double price;
    int quantity;

    public Product(String farmerName, String productName, double price, int quantity) {
        this.farmerName = farmerName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}