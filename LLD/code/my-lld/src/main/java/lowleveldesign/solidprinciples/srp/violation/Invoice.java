package lowleveldesign.solidprinciples.srp.violation;

public class Invoice {
    private Marker marker;
    private Integer quantity;

    public Invoice(Marker marker, Integer quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Responsibility:1
     */
    public Integer calculateAmount() {
        return marker.getPrice() * quantity;
    }

    /**
     * Responsibility:2
     */

    public void print() {
     System.out.println("Invoice:" + calculateAmount());
    }

    /**
     *  Responsibility:3
     */
    public void saveToDB() {
        //saveToDB
    }


    /**
     * here this class has multiple reasons to change for example database save rule changes or print format changes then we
     * have to modify the same class. The issue is that the class has multiple reasons to change. It makes things complicated.
     * 1. Higher chance of breaking an existing code accidentally
     * 2. Harder to test because because we may have to deal with other functions as well.
     * 3. More merge conflicts in team
     * 4. The classes become harder to understand
     * 5. with SRP, classes can be resued in different context. fir example, different types of invoices can use same printer class
     */
}

