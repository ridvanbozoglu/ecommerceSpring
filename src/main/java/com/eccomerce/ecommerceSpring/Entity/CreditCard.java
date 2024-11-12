package com.eccomerce.ecommerceSpring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_no")
    @Pattern(regexp = "^[0-9]{11}$", message = "Card number must be exactly 11 digits")
    private String cardNo;

    @Column(name = "exparie_date")
    private YearMonth expatriateDate;

    @Column(name = "cvv")
    @Pattern(regexp = "^[0-9]{3}$", message = "Card number must be exactly 3 digits")
    private String cvv;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;
}
