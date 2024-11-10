package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;

import java.util.List;

public interface ItemsService {
    List<Items> getAll();

    List<ItemsIn> post(ItemsIn[] items);
}
