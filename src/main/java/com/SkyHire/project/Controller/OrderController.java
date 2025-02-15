package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Entity.OrderDTO;
import com.SkyHire.project.Service.Implementation.OrderServiceImpl;
import com.SkyHire.project.Service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrderController {

    private final OrderServiceImpl orderService;

    OrderController(OrderServiceImpl orderService ){

        this.orderService=orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderDTO orderDTO){



            orderService.addOrder(orderDTO);
          return  ResponseEntity.status(HttpStatus.OK).body("Order has been successfully placed");

    }

    @GetMapping("getOrders/{userID}")
    public ResponseEntity<?> getOrders(@PathVariable Long userID){

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrder(userID));
    }
}
