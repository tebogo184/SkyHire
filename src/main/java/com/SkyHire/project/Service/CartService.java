package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Repository.CartRepo;

import java.util.Optional;

public interface CartService {

    Optional<Cart> getCart(Long userID);

    Cart addCartItem(Long userID,Long productID);

    void deleteCart(Long userID);




}
