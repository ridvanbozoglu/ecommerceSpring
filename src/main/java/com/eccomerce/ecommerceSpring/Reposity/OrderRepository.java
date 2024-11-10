package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
