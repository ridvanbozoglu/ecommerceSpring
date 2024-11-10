package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items,Long> {
}
