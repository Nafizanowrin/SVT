package com.example.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private BookingService bookingService;

//                            ** Question 9 **

    @Test
    void ProcessPayment() {

        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        when(paymentService.processPayment(999.0)).thenReturn(true);

        // Call the method under test
        boolean result = bookingService.bookService(999.0);

        // Verify the result
        assertTrue(result);

        verify(paymentService, times(1)).processPayment(999.0);
    }
}
