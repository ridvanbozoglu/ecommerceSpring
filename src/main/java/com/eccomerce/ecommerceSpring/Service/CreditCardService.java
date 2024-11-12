package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import com.eccomerce.ecommerceSpring.Entity.User;

import java.util.List;

public interface CreditCardService {
    CreditCard findById(Long id);
    CreditCard save(CreditCard creditCard);
    CreditCard update(CreditCard creditCard);
    CreditCard delete(Long id);
    List<CreditCard> findAll();
}
