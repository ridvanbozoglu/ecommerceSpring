package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Entity.CartItem;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Reposity.CartRepository;
import com.eccomerce.ecommerceSpring.Reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    private UserService userService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Override
    public Cart getCart() {
        User user = userService.findCurrentUser();
        System.out.println(user.getCart());
        return user.getCart();
    }

    @Override
    public Cart incrementCartItem(Long cartItemId) {
        User user = userService.findCurrentUser();
        Cart cart = user.getCart();
        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.incrementQuantity();
        return cartRepository.save(cart);
    }

    @Override
    public Cart decrementCartItem(Long cartItemId) {
        User user = userService.findCurrentUser();
        Cart cart = user.getCart();
        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.decrementQuantity();
        return cartRepository.save(cart);
    }




}
