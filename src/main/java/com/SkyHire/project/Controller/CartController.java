package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Service.Implementation.CartServiceImpl;
import com.SkyHire.project.Utility.ApiErrorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartServiceImpl cartService;

    CartController(CartServiceImpl cartService){

        this.cartService=cartService;
    }

    @PostMapping("/addCart")
    public ResponseEntity<?> addToCart(@Valid @RequestBody Cart cart){



           cartService.addCartItem(cart);

           return  ResponseEntity.status(HttpStatus.CREATED).body("Cart has been added");

    }



    @GetMapping("/getCart/{userID}")
    public ResponseEntity<?> getCartItem(@PathVariable Long userID){


           return ResponseEntity.status(HttpStatus.OK).body(cartService.getCart(userID));

    }
    @DeleteMapping("/deleteCart/{userID}")
    public ResponseEntity<?> deleteCart(@PathVariable Long userID){


            cartService.deleteCart(userID);
            return ResponseEntity.ok("Cart has been deleted");

    }

}
