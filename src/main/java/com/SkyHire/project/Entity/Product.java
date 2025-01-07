package com.SkyHire.project.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

@Entity
@Table(name = "Product")
@Data

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


}
