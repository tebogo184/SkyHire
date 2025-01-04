package com.SkyHire.project.Repository;

import com.SkyHire.project.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
