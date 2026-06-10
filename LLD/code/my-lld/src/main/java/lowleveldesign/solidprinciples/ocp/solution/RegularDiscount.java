package lowleveldesign.solidprinciples.ocp.solution;

public class RegularDiscount implements DiscountStrategy {
    @Override
    public double calculate(int amount) {
        return amount * 0.10;
    }
}
