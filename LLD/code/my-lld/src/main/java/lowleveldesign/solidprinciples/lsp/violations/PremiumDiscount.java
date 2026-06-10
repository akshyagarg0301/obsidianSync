package lowleveldesign.solidprinciples.lsp.violations;

public class PremiumDiscount implements Discount {
    @Override
    public double calculate(int amount) {
        if (amount < 1000) { throw new IllegalArgumentException("Minimum amount is 1000"); } return amount * 0.20;
    }
}
