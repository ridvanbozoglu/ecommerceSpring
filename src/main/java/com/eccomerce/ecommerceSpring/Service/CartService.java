package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Entity.CartItem;
import com.eccomerce.ecommerceSpring.dto.CartItemDto;

public interface CartService {
    Cart incrementCartItem(Long cartItemId);
    Cart decrementCartItem(Long cartItemId);
    Cart getCart();
    Cart addToCart(CartItemDto cartItemDto);

    Cart removeFromCart(Long id);
}
