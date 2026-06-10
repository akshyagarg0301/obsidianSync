package lowleveldesign.solidprinciples.isp.solutions;

public class Demo {
    public static void main(String[] args) {
        InvoicePrinter invoicePrinter = new InvoicePrinter(new OfficeMachine());
        invoicePrinter.print("invoice");
    }
}
