package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Order;
import com.eccomerce.ecommerceSpring.dto.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getPrevOrders();


    Order save(OrderRequest orderRequest);
}
