package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Cart;
import com.SkyHire.project.Entity.Order;
import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.ExceptionHandle.InvalidInputException;
import com.SkyHire.project.ExceptionHandle.ResourceNotFoundException;
import com.SkyHire.project.Repository.CartRepo;
import com.SkyHire.project.Repository.OrderRepo;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Repository.UserRepo;
import com.SkyHire.project.Service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service


public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;

    private final ProductRepo productRepo;
    private final UserRepo userRepo;


    private final OrderServiceImpl orderServiceImpl;

    public CartServiceImpl(CartRepo cartRepo, ProductRepo productRepo, UserRepo userRepo, OrderServiceImpl orderServiceImpl) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public Cart getCart(Long userID) {
        return cartRepo.findById(userID).orElseThrow(()-> new ResourceNotFoundException("Cart does not exist"));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Cart addCartItem(Cart cart) {


        if(!userRepo.existsById(cart.getUserID())||!productRepo.existsById(cart.getProductID())){
            throw new InvalidInputException("Failed to process request,input is invalid");
        }

        return cartRepo.save(cart);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteCart(Long userID) {

        if(!cartRepo.existsById(userID)){
            throw new InvalidInputException("User input is invalid");
        }
        cartRepo.deleteById(userID);

    }

}
