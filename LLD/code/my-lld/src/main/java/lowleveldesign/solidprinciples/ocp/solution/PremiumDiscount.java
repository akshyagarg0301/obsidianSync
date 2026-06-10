package lowleveldesign.solidprinciples.ocp.solution;

public class PremiumDiscount implements DiscountStrategy {
    @Override
    public double calculate(int amount) {
        return amount * 0.20;
    }
}
