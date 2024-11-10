package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Items;
import com.eccomerce.ecommerceSpring.Service.ItemsService;
import com.eccomerce.ecommerceSpring.dto.ItemsIn;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Items> getAllProducts(){
        return itemsService.getAll();
    }


    @PostMapping("/")
    public List<ItemsIn> postItems(@RequestBody ItemsIn... items){
        return itemsService.post(items);
    }




}
