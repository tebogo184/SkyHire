package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Repository.OrderRepo;
import com.SkyHire.project.Service.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Override
    public List<Order> getAllOrder(Long userID) {

        List<Order> orderList=orderRepo.findAll();


        return  orderList.stream().filter(order -> order.getUserID().equals(userID)).toList();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Order addOrder(Order order) {


        return orderRepo.save(order);
    }

    @Override
    public Optional<Order> getOrder(Long orderID) {


        return orderRepo.findById(orderID);
    }
}
