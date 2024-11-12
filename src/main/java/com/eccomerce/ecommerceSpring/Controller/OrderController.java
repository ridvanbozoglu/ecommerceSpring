package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Order;
import com.eccomerce.ecommerceSpring.Service.OrderService;
import com.eccomerce.ecommerceSpring.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<Order> prevOrders(){
        return orderService.getPrevOrders();
    }

    @PostMapping("/")
    public Order save(@RequestBody OrderRequest orderRequest){
        return orderService.save(orderRequest);
    }
}
