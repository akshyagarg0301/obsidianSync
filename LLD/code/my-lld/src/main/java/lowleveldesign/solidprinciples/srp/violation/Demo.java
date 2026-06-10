package lowleveldesign.solidprinciples.srp.violation;

public class Demo {

    public static void main(String[] args) {
        Invoice invoice = new Invoice(new Marker("fountain", 20), 10);
        invoice.print();
        invoice.saveToDB();
    }
}
