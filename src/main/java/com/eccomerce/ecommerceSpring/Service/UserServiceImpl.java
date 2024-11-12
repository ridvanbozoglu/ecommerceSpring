package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> {
                    System.out.println("User credentials are not valid");
                    throw new ApiException("User credentials are not valid",HttpStatus.BAD_REQUEST);
                });
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Id  not valid");
                    throw new ApiException("Id not valid",HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public User findCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        return userRepository.findUserByEmail(currentUsername)
                .orElseThrow(() -> new ApiException("User not found",HttpStatus.NOT_FOUND));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
