package lowleveldesign.solidprinciples.lsp.solutions;

public interface Discount {
    boolean isApplicable(double amount);
    double apply(double amount);
}
