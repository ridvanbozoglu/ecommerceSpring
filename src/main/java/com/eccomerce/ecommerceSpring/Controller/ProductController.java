package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.Service.ItemsService;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ItemsService itemsService;

    @Autowired
    public ProductController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/")
    public Page<Items> getItemsByCategory(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "sort", required = false, defaultValue = "price:asc") String sort) {
        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }
        return itemsService.getAll(category, filter, limit, offset,sort);
    }


    @PostMapping("/")
    public List<ItemsIn> postItems(@RequestBody ItemsIn... items){
        return itemsService.post(items);
    }




}
