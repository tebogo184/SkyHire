package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Product;
import com.SkyHire.project.ExceptionHandle.InvalidInputException;
import com.SkyHire.project.ExceptionHandle.ResourceNotFoundException;
import com.SkyHire.project.Repository.ProductRepo;
import com.SkyHire.project.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

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

        if(!productRepo.existsById(productID)){

            throw new InvalidInputException("User input is invalid");
        }

        productRepo.deleteById(productID);
        return productRepo.findAll();
    }

    @Override
    public Product getProductByID(Long productID)  {

        var product=productRepo.findById(productID);

        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product does not exist");
        }
        return product.get();
    }
}
