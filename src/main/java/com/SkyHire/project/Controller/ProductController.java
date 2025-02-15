package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Service.Implementation.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private  final ProductServiceImpl productService;

    ProductController (ProductServiceImpl productService){
        this.productService = productService;

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){

            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());

    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> getProductById(Long prodID)  {
        
            return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByID(prodID));

    }
}
