package com.example.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//                                ** Question 3 **

class LoginManagerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private LoginManager loginManager;

    @Test
    void ValidCredentials() throws Exception {

        MockitoAnnotations.openMocks(this);

        when(authenticationService.authenticate("Nowrin", "007")).thenReturn(true);
        boolean result = loginManager.login("Nowrin", "007");

        assertTrue(result, "Login successful!");
        verify(authenticationService).authenticate("Nowrin", "007");
    }

    @Test
    void InvalidCredentials() throws Exception {

        MockitoAnnotations.openMocks(this);


        when(authenticationService.authenticate("Nowrin", "007")).thenReturn(false);
        boolean result = loginManager.login("NIN", "16");

        assertFalse(result, "Login failed");
        verify(authenticationService).authenticate("NIN", "16");
    }

    @Test
    void NullUsernameOrPassword() {

        MockitoAnnotations.openMocks(this);


        Exception exception = assertThrows(Exception.class, () -> loginManager.login(null, "007"));
        assertEquals("Username and password cannot be null", exception.getMessage());


        exception = assertThrows(Exception.class, () -> loginManager.login("Nowrin", null));
        assertEquals("Username and password cannot be null", exception.getMessage());


        verify(authenticationService, never()).authenticate(anyString(), anyString());
    }
}
