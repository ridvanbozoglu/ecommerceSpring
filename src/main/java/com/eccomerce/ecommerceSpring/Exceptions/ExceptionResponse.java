package com.eccomerce.ecommerceSpring.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime;

}
