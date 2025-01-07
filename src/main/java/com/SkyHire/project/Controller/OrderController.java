package com.SkyHire.project.Controller;

import com.SkyHire.project.Service.Implementation.OrderServiceImpl;
import com.SkyHire.project.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderServiceImpl orderService;

    OrderController(OrderServiceImpl orderService ){

        this.orderService=orderService;
    }

    @GetMapping("getOrders/{userID}")
    public ResponseEntity<?> getOrders(@PathVariable Long userID){

        return ResponseEntity.ok(orderService.getAllOrder(userID));
    }
}
