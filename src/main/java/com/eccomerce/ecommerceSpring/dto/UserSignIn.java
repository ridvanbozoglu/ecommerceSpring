package com.eccomerce.ecommerceSpring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserSignIn (@NotNull @Size(min = 2, message = "First name less than 2 charhacters") String firstName,
                          @NotNull @Size(min = 2, message = "Last name less than 2 charhacters")String lastName,
                          @NotNull @Email(message = "Invalid email format") String email,
                          @Size(min = 3, max = 40, message = "Password must be between 3 and 40 characters long")String password,
                          String role){
}
