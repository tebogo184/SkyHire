package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> addProduct(Product product) {
         productRepo.save(product);

         return productRepo.findAll();
    }

    @Override
    public List<Product> deleteProduct(Long productID) {
        return null;
    }
}
