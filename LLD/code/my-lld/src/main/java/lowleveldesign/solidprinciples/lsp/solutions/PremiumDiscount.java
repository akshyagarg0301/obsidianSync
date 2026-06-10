package lowleveldesign.solidprinciples.lsp.solutions;

public class PremiumDiscount implements Discount{
    @Override
    public double apply(double amount) {
        return amount * 0.20;
    }

    @Override
    public boolean isApplicable(double amount) {
        return  amount >= 1000;
    }
}
