package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
