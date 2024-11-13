package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Service.CartService;
import com.eccomerce.ecommerceSpring.dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public Cart getCart(){
        return cartService.getCart();
    }

    @PostMapping("/")
    public List<CartItemDto> addCartItemToCart(@RequestBody CartItemDto... cartItemDto){
        return cartService.addToCart(cartItemDto);
    }

    @DeleteMapping("/{cartItemId}")
    public Cart removeCartItemFromCart(@PathVariable Long id){
        return cartService.removeFromCart(id);
    }

    @PostMapping("/{cartItemId}/increment")
    public Cart incrementCartItem(@PathVariable Long cartItemId){
        return cartService.incrementCartItem(cartItemId);
    }

    @PostMapping("/{cartItemId}/decrement")
    public Cart decrementCartItem(@PathVariable Long cartItemId){
        return cartService.decrementCartItem(cartItemId);
    }
}
