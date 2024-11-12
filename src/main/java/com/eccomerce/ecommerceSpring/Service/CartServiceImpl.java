package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Entity.CartItem;
import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.CartRepository;
import com.eccomerce.ecommerceSpring.Reposity.UserRepository;
import com.eccomerce.ecommerceSpring.dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    private UserService userService;
    private ItemsService itemsService;
    private CartItemService cartItemService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService, ItemsService itemsService, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.itemsService = itemsService;
        this.cartItemService = cartItemService;
    }

    @Override
    public Cart getCart() {
        User user = userService.findCurrentUser();
        System.out.println(user.getCart());
        return user.getCart();
    }

    @Override
    public Cart addToCart(CartItemDto cartItemDto) {
        Cart cart = userService.findCurrentUser().getCart();
        Items item = itemsService.findById(cartItemDto.item_id());
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(cartItemDto.quantity());
        cartItem.setCart(cart);
        cart.addToCart(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeFromCart(Long id) {
        Cart cart = userService.findCurrentUser().getCart();
        cart.removeFromCart(id);
        return cartRepository.save(cart);
    }

    @Override
    public Cart incrementCartItem(Long cartItemId) {
        User user = userService.findCurrentUser();
        Cart cart = user.getCart();
        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new ApiException("Cart item not found", HttpStatus.NOT_FOUND));
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
                .orElseThrow(() -> new ApiException("Cart item not found",HttpStatus.NOT_FOUND));
        cartItem.decrementQuantity();
        return cartRepository.save(cart);
    }


}
