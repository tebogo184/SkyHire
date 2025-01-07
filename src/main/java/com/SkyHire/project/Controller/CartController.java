package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Service.Implementation.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private final CartServiceImpl cartService;

    CartController(CartServiceImpl cartService){

        this.cartService=cartService;
    }

    @PostMapping("/addCart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart){

        return ResponseEntity.ok(cartService.addCartItem(cart));
    }

    @DeleteMapping("/checkout/{userID}")
    public ResponseEntity<?> checkoutCart(@PathVariable Long userID){

        return ResponseEntity.ok(cartService.checkout(userID));
    }

    @GetMapping("/getCart/{userID}")
    public ResponseEntity<?> getCartItem(@PathVariable Long userID){

        return ResponseEntity.ok(cartService.getCart(userID));
    }
}
