package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.Repository.CartRepo;
import com.SkyHire.project.Repository.OrderRepo;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service


public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;

    private final ProductRepo productRepo;


    private final OrderServiceImpl orderServiceImpl;

    public CartServiceImpl(CartRepo cartRepo, ProductRepo productRepo, OrderServiceImpl orderServiceImpl) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public Optional<Cart> getCart(Long userID) {
        return cartRepo.findById(userID);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Cart addCartItem(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteCart(Long userID) {
        cartRepo.deleteById(userID);

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Order checkout(Long userID) {

        Cart cartToDelete=cartRepo.findById(userID).orElseThrow();
       Order newOrder= orderServiceImpl.addOrder(cartToDelete);

       cartRepo.delete(cartToDelete);

        return newOrder;
    }
}
