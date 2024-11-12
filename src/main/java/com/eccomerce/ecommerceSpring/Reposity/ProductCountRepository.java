package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.ProductCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCountRepository extends JpaRepository<ProductCount,Long> {
}
