package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;

public interface CartService {
    Cart incrementCartItem(Long cartItemId);
    Cart decrementCartItem(Long cartItemId);
    Cart getCart();
}
