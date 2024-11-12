package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_whenUserExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        UserDetails result = userService.loadUserByUsername("test@example.com");

        assertNotNull(result);
        assertEquals("test@example.com", result.getUsername());
        verify(userRepository, times(1)).findUserByEmail("test@example.com");
    }

    @Test
    void loadUserByUsername_whenUserDoesNotExist() {
        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.empty());

        ApiException exception = assertThrows(ApiException.class,
                () -> userService.loadUserByUsername("test@example.com"));

        assertEquals("User credentials are not valid", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
        verify(userRepository, times(1)).findUserByEmail("test@example.com");
    }

    @Test
    void findByID_whenUserExists() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.findByID(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void findByID_whenUserDoesNotExist() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        ApiException exception = assertThrows(ApiException.class, () -> userService.findByID(1L));

        assertEquals("Id not valid", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void findCurrentUser_whenUserExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("test@example.com");
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        User result = userService.findCurrentUser();

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(userRepository, times(1)).findUserByEmail("test@example.com");
    }

    @Test
    void findCurrentUser_whenUserDoesNotExist() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("nonexistent@example.com");
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findUserByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        ApiException exception = assertThrows(ApiException.class, () -> userService.findCurrentUser());

        assertEquals("User not found", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
        verify(userRepository, times(1)).findUserByEmail("nonexistent@example.com");
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        List<User> result = userService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }
}
