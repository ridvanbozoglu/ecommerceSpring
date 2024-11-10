package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{cartItemId}/increment")
    public Cart incrementCartItem(@PathVariable Long cartItemId){
        return cartService.incrementCartItem(cartItemId);
    }

    @PostMapping("/{cartItemId}/decrement")
    public Cart decrementCartItem(@PathVariable Long cartItemId){
        return cartService.decrementCartItem(cartItemId);
    }


}
