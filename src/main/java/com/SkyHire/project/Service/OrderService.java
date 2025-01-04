package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService  {

    List<Order> getAllOrder(Long userID);

    Order addOrder(Order order);

    Optional<Order> getOrder(Long orderID);

}
