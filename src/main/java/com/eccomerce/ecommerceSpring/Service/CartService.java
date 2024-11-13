package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.dto.CartItemDto;

import java.util.List;

public interface CartService {
    Cart incrementCartItem(Long cartItemId);
    Cart decrementCartItem(Long cartItemId);
    Cart getCart();
    List<CartItemDto> addToCart(CartItemDto[] cartItemDto);

    Cart removeFromCart(Long id);
}
