package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("John Doe");

        when(userService.findByID(1L)).thenReturn(user);

        User result = userController.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getFirstName());
        verify(userService, times(1)).findByID(1L);
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John Doe");

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Jane Doe");

        List<User> users = Arrays.asList(user1, user2);

        when(userService.findAll()).thenReturn(users);

        List<User> result = userController.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getFirstName());
        assertEquals("Jane Doe", result.get(1).getFirstName());
        verify(userService, times(1)).findAll();
    }
}
