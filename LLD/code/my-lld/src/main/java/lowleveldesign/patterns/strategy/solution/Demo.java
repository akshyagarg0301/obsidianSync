package lowleveldesign.patterns.strategy.solution;

public class Demo {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new UpiPaymentStrategy());
        paymentService.pay(100.0);

        /**
         * Now payment service do not need if else
         * now we can add ApplePay as a payment strategy without changing other existing classes.
         */
    }
}
