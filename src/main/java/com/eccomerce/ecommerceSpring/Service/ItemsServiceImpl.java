package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Category;
import com.eccomerce.ecommerceSpring.Entity.Gender;
import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.Reposity.ItemRepository;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService{
    private ItemRepository itemRepository;
    private CategoryService categoryService;

    @Autowired
    public ItemsServiceImpl(ItemRepository itemRepository, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Items> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<ItemsIn> post(ItemsIn[] items) {
        List<ItemsIn> itemList = Arrays.asList(items);
        List<ItemsIn> successfullySavedItems = new ArrayList<>();
        List<ItemsIn> failedItems = new ArrayList<>();

        for (ItemsIn item : itemList) {
            try {
                Category category = categoryService.getCategoryByName(item.category());
                Items newItem = new Items();
                newItem.setCategory(category);
                newItem.setDescription(item.description());
                newItem.setName(item.name());
                newItem.setPrice(item.price());
                newItem.setGender(Gender.valueOf(item.gender()));
                newItem.setImageUrl(item.imageUrl());

                Items savedItem = itemRepository.save(newItem);
                successfullySavedItems.add(item);
            } catch (Exception e) {
                System.out.println(e);
                failedItems.add(item);
            }
        }
        System.out.println("Successfully added." + successfullySavedItems);

        return failedItems;
    }

}
