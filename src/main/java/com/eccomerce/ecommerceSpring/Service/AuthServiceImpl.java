package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Cart;
import com.eccomerce.ecommerceSpring.Entity.Role;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Reposity.RoleRepository;
import com.eccomerce.ecommerceSpring.Reposity.UserRepository;
import com.eccomerce.ecommerceSpring.dto.UserSignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserSignIn userIn) {
        String encodedPassword = passwordEncoder.encode(userIn.password());
        Role userRole = roleRepository.getRoleByName(userIn.role());

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        User user = new User();
        user.setFirstName(userIn.firstName());
        user.setLastName(userIn.lastName());
        user.setEmail(userIn.email());
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);
        user.setCart(new Cart());

        return userRepository.save(user);
    }
}
