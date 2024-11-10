package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String admin(){
        return "Authenticated";
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findByID(id);
    }
}
