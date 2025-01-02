package com.SkyHire.project.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Address")
public class Address {

    @Id
    private Long Id;

    @Column(name = "streetAddress",nullable = false)
    private String streetAddress;

    @Column(name="suburb",nullable = false)
    private String suburb;

    @Column(name = "zipCode",nullable = false)
    private String zipCode;


}
