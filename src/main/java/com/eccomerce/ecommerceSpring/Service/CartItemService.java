package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CartItem;

public interface CartItemService {
    CartItem findById(Long id);
}
