package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemsService {
    Items findById(Long id);
    List<ItemsIn> post(ItemsIn[] items);

    Page<Items> getAll(String category,String filter, Integer limit, int offset, String sort);
}
