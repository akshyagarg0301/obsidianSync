package lowleveldesign.solidprinciples.srp.solution;

public class Demo {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(new Marker("fountain", 20), 10);
        InvoicePrinter invoicePrinter = new InvoicePrinter();
        invoicePrinter.print(invoice);
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        invoiceRepository.save(invoice);
    }
}
