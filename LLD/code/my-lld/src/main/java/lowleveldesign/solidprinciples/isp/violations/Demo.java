package lowleveldesign.solidprinciples.isp.violations;

public class Demo {
    public static void main(String[] args) {
        InvoicePrinter invoicePrinter = new InvoicePrinter(new OfficeMachine());
        invoicePrinter.printInvoice("invoice");
    }
}
/**
 * here invoice printer only used print method but it has to implement all the methods of MultiFunctionDevice. This is ISP  because
 * the client InvoicePrinter depends on methods it does not need: scan() and fax().
 */

