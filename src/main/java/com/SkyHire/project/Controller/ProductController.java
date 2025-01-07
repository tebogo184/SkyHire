package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.Repository.ProductRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private  final ProductRepo productRepo ;

    ProductController (ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){

        return productRepo.findAll();
    }

    @GetMapping("/getProduct")
    public Product getProductById(Long prodID){

        return productRepo.findById(prodID).get();
    }
}
