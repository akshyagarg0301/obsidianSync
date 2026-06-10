package lowleveldesign.solidprinciples.lsp.solutions;

public class Demo {
    public static void main(String[] args) {
        Discount premiumDiscount = new PremiumDiscount();
        int amount  = 500;
        if (premiumDiscount.isApplicable(500)) {
            double result = premiumDiscount.apply(amount);
            System.out.println(result);
        } else {
            System.out.println("Discount not applicable");
        }
    }
}
