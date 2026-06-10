package lowleveldesign.solidprinciples.ocp.violation;

public class Demo {
    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double discount = discountCalculator.calculateDiscount("REGULAR", 100);
        System.out.println("Discount: " + discount);
    }
}

/**
 * Suppose a new type of customer is added then we have to modify the same class which is aready tested in production.
 */

