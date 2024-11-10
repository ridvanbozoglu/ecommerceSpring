package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import com.eccomerce.ecommerceSpring.Entity.User;

public interface CreditCardService {
    CreditCard save(User user, CreditCard creditCard);
    CreditCard update(CreditCard creditCard);
    CreditCard delete(Long id);
}
