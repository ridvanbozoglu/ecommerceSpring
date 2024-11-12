package com.eccomerce.ecommerceSpring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCount> cartItems = new ArrayList<>();

    public boolean addToCart(ProductCount cartItem){
        cartItems.add(cartItem);
        return true;
    }

    public boolean removeFromCart(Long id){
        if (cartItems == null || cartItems.isEmpty()){
            return false;
        }
        Optional<ProductCount> cartItem = cartItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if(cartItem.isPresent()){
            cartItems.remove(cartItem.get());
            return true;
        }else return false;
    }
}
