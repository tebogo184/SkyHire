package com.SkyHire.project.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    private Long userID;

    private Long productID;

    private float total;

    private Date  dateBought;

}
