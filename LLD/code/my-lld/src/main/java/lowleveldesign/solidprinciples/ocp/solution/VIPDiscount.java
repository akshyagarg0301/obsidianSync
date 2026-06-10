package lowleveldesign.solidprinciples.ocp.solution;

public class VIPDiscount implements DiscountStrategy {
    @Override
    public double calculate(int amount) {
        return amount * 0.30;
    }
}
