package lowleveldesign.solidprinciples.ocp.solution;

public class Demo {
    public static void main(String[] args) {
        DiscountStrategy discountStrategy = new RegularDiscount();
        double discount = discountStrategy.calculate(100);
        System.out.println("Discount: " + discount);
    }
}
/**
 * here if wenat to extend for a new customer type we can easily add a new strategy by iheriting the interface without breaking
 * any existing code
 * Bad:Modify DiscountCalculator every time a new discount type is added
 * Good:Add a new DiscountStrategy class without changing old discount code
 *
 * SRP:
 * “Does this class have only one job?”
 *
 * OCP:
 * “Can I add new behavior without changing existing code?”
 *
 * SRP is about separating responsibilities.
 * OCP is about extending behavior safely.
 */

