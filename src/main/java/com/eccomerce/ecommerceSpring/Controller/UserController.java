package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findByID(id);
    }

    @GetMapping("/")
    public User findCurrent(){
        return userService.findCurrentUser();
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }
}
