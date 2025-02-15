package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.*;
import com.SkyHire.project.ExceptionHandle.InvalidInputException;
import com.SkyHire.project.Repository.CartRepo;
import com.SkyHire.project.Repository.OrderRepo;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Repository.UserRepo;
import com.SkyHire.project.Service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final CartRepo cartRepo;

    public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo, UserRepo userRepo, CartRepo cartRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.cartRepo = cartRepo;
    }

    @Override
    public List<Order> getAllOrder(Long userID) {

        List<Order> orderList = orderRepo.findAll();


        return orderList.stream().filter(order -> order.getUserID().equals(userID)).toList();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addOrder(OrderDTO orderDTO) {

        Order order = orderDTO.getOrder();

        UserEntity user = userRepo.findById(order.getUserID()).orElseThrow(() -> new InvalidInputException("Failed to place order, invalid input"));

        user.setIdNumber(orderDTO.getIdNumber());

        Order newOrder = new Order();

        newOrder.setStartDate(order.getStartDate());
        newOrder.setEndDate(order.getEndDate());
        newOrder.setTotal(order.getTotal());
        newOrder.setUserID(order.getUserID());
        newOrder.setAddress(order.getAddress());
        newOrder.setProductID(order.getProductID());

        cartRepo.deleteById(user.getUserID());
        userRepo.save(user);


    }


    @Override
    public Optional<Order> getOrder(Long orderID) {


        return orderRepo.findById(orderID);
    }
}
