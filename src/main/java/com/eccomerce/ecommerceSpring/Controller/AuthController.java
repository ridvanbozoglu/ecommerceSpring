package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Service.AuthService;

import com.eccomerce.ecommerceSpring.dto.UserSignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String welcome(){
        return "hiii";
    }

    @PostMapping("/")
    public User register(@RequestBody UserSignIn user){
        return authService.register(user);
    }
}
