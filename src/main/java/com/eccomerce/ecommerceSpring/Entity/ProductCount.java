package com.eccomerce.ecommerceSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_count")
public class ProductCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int quantity = 1;

    public int incrementQuantity(){
        return ++quantity;
    }

    public int decrementQuantity(){
        if(quantity == 0){
            return quantity;
        }
        return --quantity;
    }
}

