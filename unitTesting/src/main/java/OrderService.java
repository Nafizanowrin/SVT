public class OrderService {
    private final PaymentService paymentService;
    public OrderService(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    public boolean processOrder(int orderId) {
        return paymentService.processPayment(orderId);
    }
}

class PaymentService{
    boolean processPayment(int orderId){
        return true;
    }
}
