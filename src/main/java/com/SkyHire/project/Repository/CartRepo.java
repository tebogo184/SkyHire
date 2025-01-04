package com.SkyHire.project.Repository;

import com.SkyHire.project.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Long> {
}
