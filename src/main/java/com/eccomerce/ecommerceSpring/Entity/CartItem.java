package com.eccomerce.ecommerceSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_cart_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items item;

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

