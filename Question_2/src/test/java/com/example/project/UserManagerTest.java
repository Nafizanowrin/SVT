package com.example.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//                            ** Question 1 **

class UserManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserManager userManager;

    @Test
    void validUser() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        when(userService.usernameExists("validUser")).thenReturn(false);
        when(userService.saveUser("validUser", "password")).thenReturn(true);

        boolean result = userManager.registerUser("validUser", "password");

        // Verify
        assertTrue(result, "Registration successful!");
        verify(userService).usernameExists("validUser");
        verify(userService).saveUser("validUser", "password");
    }

    @Test
    void UserExisting() {

        MockitoAnnotations.openMocks(this);

        when(userService.usernameExists("existingUser")).thenReturn(true);
        boolean result = userManager.registerUser("existingUser", "password");

        assertFalse(result, "Registration failed");
        verify(userService).usernameExists("existingUser");
        verify(userService, never()).saveUser(anyString(), anyString());
    }

    @Test
    void RegisterUserSaveFailure() {

        MockitoAnnotations.openMocks(this);

        when(userService.usernameExists("validUser")).thenReturn(false);
        when(userService.saveUser("validUser", "password")).thenReturn(false);
        boolean result = userManager.registerUser("validUser", "password");


        assertFalse(result, "Registration failed");
        verify(userService).usernameExists("validUser");
        verify(userService).saveUser("validUser", "password");
    }
}
