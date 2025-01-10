package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.Repository.OrderRepo;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Override
    public List<Order> getAllOrder(Long userID) {

        List<Order> orderList=orderRepo.findAll();


        return  orderList.stream().filter(order -> order.getUserID().equals(userID)).toList();
    }

    @Override

    public Order addOrder(Cart cart) {

        Product product=productRepo.findById(cart.getProductID()).orElseThrow();

        Order order =new Order();

        order.setDateBought(new Date());
        order.setTotal(product.getPrice());
        order.setUserID(cart.getUserID());

        return orderRepo.save(order);
    }

    @Override
    public Optional<Order> getOrder(Long orderID) {


        return orderRepo.findById(orderID);
    }
}
