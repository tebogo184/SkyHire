package com.SkyHire.project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(name = "ImageSource",nullable = false)
    private String imgSrc;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private float price;

    @Column(name = "size",nullable = false)
    private String size;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "color",nullable = false)
    private String color;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name="isAvailable",nullable = false)
    private boolean isAvailable;




    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }


}
