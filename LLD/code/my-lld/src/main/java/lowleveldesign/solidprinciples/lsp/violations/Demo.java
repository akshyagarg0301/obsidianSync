package lowleveldesign.solidprinciples.lsp.violations;

public class Demo {
    public static void main(String[] args) {
        Discount premiumDiscount = new PremiumDiscount();
        double discount = premiumDiscount.calculate(500);
        System.out.println("Discount: " + discount);
    }
}
/**
 * here the expectation is we will get discount but we got illegal arguement exception
 */