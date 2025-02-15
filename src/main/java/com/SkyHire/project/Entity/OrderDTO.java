package com.SkyHire.project.Entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class OrderDTO {

    @NotNull
    private String idNumber;

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String  idNumber) {
        this.idNumber = idNumber;
    }
}
