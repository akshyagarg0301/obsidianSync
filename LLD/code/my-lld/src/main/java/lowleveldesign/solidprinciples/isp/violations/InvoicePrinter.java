package lowleveldesign.solidprinciples.isp.violations;

public class InvoicePrinter {

    private final MultiFunctionDevice device;

    public InvoicePrinter(MultiFunctionDevice device) {
        this.device = device;
    }

    public void printInvoice(String invoice) {
        device.print(invoice);
    }
}
