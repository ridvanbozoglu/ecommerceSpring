package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Category;
import com.eccomerce.ecommerceSpring.Entity.Gender;
import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.ItemRepository;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
    public Page<Items> getAll(String category, String filter, Integer limit, int offset, String sort) {
        String[] parts = sort.split(":");
        String sortName = parts[0];
        String sortDirectionFromUrl = parts[1];

        Sort.Direction sortDirection = Sort.Direction.fromString(sortDirectionFromUrl);
        Sort.Order order = new Sort.Order(sortDirection, sortName);
        Sort sortBy = Sort.by(order);

        Pageable pageable = PageRequest.of(offset, limit, sortBy);

        if (category != null && !category.isEmpty()) {
            Long categoryId = categoryService.getCategoryByName(category).getId();
            if (filter != null && !filter.isEmpty()) {
                return itemRepository.findByFilterAndCategory(category, filter, pageable);
            } else {
                return itemRepository.findByCategory(category, pageable);
            }
        } else {
            if (filter != null && !filter.isEmpty()) {
                return itemRepository.findByFilter(filter, pageable);
            } else {
                return itemRepository.findAll(pageable);
            }
        }
    }

    @Override
    public Items findById(Long id) {
        return itemRepository.findById(id).orElseThrow(()-> new ApiException("Item not found", HttpStatus.NOT_FOUND));
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
