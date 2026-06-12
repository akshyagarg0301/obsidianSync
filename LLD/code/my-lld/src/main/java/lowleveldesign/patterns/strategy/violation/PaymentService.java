package lowleveldesign.patterns.strategy.violation;

public class PaymentService {
    public void pay(String paymentType, double amount) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Paying " + amount + " using credit card");
        }
        else if (paymentType.equals("UPI")) {
            System.out.println("Paying " + amount + " using UPI");
        }
        else if (paymentType.equals("PAYPAL")) {
            System.out.println("Paying " + amount + " using PayPal");
        }
        else {
            System.out.println("Invalid payment type");
        }
    }
}
