package lowleveldesign.solidprinciples.isp.solutions;

public class OfficeMachine implements Printable, Scannable, Faxable {

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }

    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("Faxing: " + document);
    }
}
