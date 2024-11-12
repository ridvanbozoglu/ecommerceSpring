package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.*;
import com.eccomerce.ecommerceSpring.Reposity.OrderRepository;
import com.eccomerce.ecommerceSpring.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private CreditCardService creditCardService;
    private AddressService addressService;
    private UserService userService;
    private ProductCountService cartItemService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CreditCardService creditCardService, AddressService addressService, UserService userService, ProductCountService cartItemService) {
        this.orderRepository = orderRepository;
        this.creditCardService = creditCardService;
        this.addressService = addressService;
        this.userService = userService;
        this.cartItemService = cartItemService;
    }

    @Override
    public List<Order> getPrevOrders() {
        User user = userService.findCurrentUser();
        return user.getOrders();
    }

    @Override
    public Order save(OrderRequest orderRequest) {
        Address address = addressService.getAddressById(orderRequest.address_id());


        CreditCard card = creditCardService.findById(orderRequest.card_id());
        User user = card.getUser();

        List<ProductCount> basket = new LinkedList<>();

        for (Long product_id : orderRequest.products_id()) {
            ProductCount cartItem = cartItemService.findById(product_id);
            basket.add(cartItem);
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderTime(LocalDateTime.now());
        order.setAddress(address);
        order.setCreditCard(card);
        order.setBasket(basket);

        return orderRepository.save(order);
    }




}
