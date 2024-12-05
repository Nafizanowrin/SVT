package com.example.project;

public class BookingService {
    private final PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean bookService(double amount) {
        return paymentService.processPayment(amount);
    }
}
