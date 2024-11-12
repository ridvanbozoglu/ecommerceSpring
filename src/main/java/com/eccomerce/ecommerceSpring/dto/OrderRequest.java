package com.eccomerce.ecommerceSpring.dto;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(
        @Positive(message = "Address id must be positive") Long address_id,
        @Positive(message = "Card id must be positive") Long card_id,
        @Positive(message = "price must be positive") int price,
        List<Long> products_id
) {}

