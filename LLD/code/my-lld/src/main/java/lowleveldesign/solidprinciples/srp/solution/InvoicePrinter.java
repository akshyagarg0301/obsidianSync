package lowleveldesign.solidprinciples.srp.solution;

public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Invoice:" + invoice.calculateAmount());
    }
}
