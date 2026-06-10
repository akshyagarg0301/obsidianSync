package lowleveldesign.solidprinciples.srp.solution;

public class Invoice {
    private Marker marker;
    private Integer quantity;

    public Invoice(Marker marker, Integer quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer calculateAmount() {
        return marker.getPrice() * quantity;
    }
}
