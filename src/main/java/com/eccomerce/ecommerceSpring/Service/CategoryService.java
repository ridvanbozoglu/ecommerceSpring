package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category getCategoryByName(String name);
}
