package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select c from Category c where LOWER(c.name) = LOWER(:name)")
    Category findByName(String name);
}
