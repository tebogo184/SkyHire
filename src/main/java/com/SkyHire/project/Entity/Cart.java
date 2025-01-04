package com.SkyHire.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    private Long userID;
    private Long productID;

}
