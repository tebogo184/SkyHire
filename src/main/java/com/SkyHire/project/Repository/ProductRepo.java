package com.SkyHire.project.Repository;

import com.SkyHire.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
