package com.SkyHire.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cart")

public class Cart {


    public Cart(){}
    public Cart(Long productID,Long  userID) {
        this.productID = productID;
        this.userID=userID;
    }

    @Id
    private Long userID;
    private Long productID;


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
}
