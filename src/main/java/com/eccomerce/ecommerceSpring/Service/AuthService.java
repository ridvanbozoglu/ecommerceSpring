package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.dto.UserSignIn;

public interface AuthService {

    User register(UserSignIn user);
}
