package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.ProductCount;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.ProductCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements ProductCountService{
    private ProductCountRepository productCountRepository;

    @Autowired
    public CartItemServiceImpl(ProductCountRepository productCountRepository) {
        this.productCountRepository = productCountRepository;
    }

    @Override
    public ProductCount findById(Long id) {
        return productCountRepository.findById(id).orElseThrow(()-> new ApiException("Could not be found", HttpStatus.NOT_FOUND));
    }
}
