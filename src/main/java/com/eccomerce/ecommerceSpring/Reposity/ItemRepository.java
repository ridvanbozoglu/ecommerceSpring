package com.eccomerce.ecommerceSpring.Reposity;

import com.eccomerce.ecommerceSpring.Entity.Items;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Items, Long> {
    @Query("SELECT i FROM Items i WHERE LOWER(i.category.name) = LOWER(:category)")
    Page<Items> findByCategory(String category, Pageable pageable);

    @Query("SELECT i FROM Items i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :filter, '%'))")
    Page<Items> findByFilter(String filter, Pageable pageable);

    @Query("SELECT i FROM Items i WHERE LOWER(i.category.name) = LOWER(:category) AND LOWER(i.name) LIKE LOWER(CONCAT('%', :filter, '%'))")
    Page<Items> findByFilterAndCategory(String category, String filter, Pageable pageable);

}
