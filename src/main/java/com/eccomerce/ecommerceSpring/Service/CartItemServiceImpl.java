package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CartItem;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElseThrow(()-> new ApiException("Could not be found", HttpStatus.NOT_FOUND));
    }
}
