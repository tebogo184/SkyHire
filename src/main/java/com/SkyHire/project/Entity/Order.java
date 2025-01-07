package com.SkyHire.project.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @NotNull
    private Long userID;

    @NotNull
    private Long productID;

    @NotNull
    @Positive
    private float total;

    @NotNull

    private Date  dateBought;

}
