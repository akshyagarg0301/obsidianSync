package lowleveldesign.patterns.strategy.violation;

public class Demo {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.pay("CREDIT_CARD", 100.0);
        paymentService.pay("UPI", 200.0);
        paymentService.pay("PAYPAL", 300.0);
        paymentService.pay("INVALID", 400.0);

        /**
         * now if i have to add apple-pay then I have to change Payment Service
         * which causes break of Open Closed Principle
         */
    }
}
