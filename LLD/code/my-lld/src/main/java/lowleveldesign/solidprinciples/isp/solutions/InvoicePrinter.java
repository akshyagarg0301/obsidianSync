package lowleveldesign.solidprinciples.isp.solutions;

public class InvoicePrinter {
    private final Printable printable;

    public InvoicePrinter(Printable printable) {
        this.printable = printable;
    }

    public void print(String invoice) {
        printable.print(invoice);
    }
}
