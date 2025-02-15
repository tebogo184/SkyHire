package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Entity.OrderDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public interface OrderService  {

    List<Order> getAllOrder(Long userID);

    void addOrder(OrderDTO orderDTO);

    Optional<Order> getOrder(Long orderID);





}
