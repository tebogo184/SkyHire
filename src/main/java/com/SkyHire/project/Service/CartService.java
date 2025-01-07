package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Repository.CartRepo;

import java.util.Optional;

public interface CartService {

    Optional<Cart> getCart(Long userID);

    Cart addCartItem(Cart cart);

    void deleteCart(Long userID);

    Order checkout(Long userID);




}
