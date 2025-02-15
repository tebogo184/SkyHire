package com.SkyHire.project.Service;


import com.SkyHire.project.Entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();

    List<Product> addProduct(Product product);

    List<Product> deleteProduct(Long productID);

    Product getProductByID(Long productID) throws Exception;
}
