package com.eccomerce.ecommerceSpring.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
