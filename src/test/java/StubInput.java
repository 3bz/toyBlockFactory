import io.Input;

public class StubInput implements Input {
    private String name;
    private int orderQuantity;

    public StubInput(String aName, int aOrderQuantity) {
        name = aName;
        orderQuantity = aOrderQuantity;
    }

    @Override
    public int takeOrderQuantity() {
        return orderQuantity;
    } //Takeorderquantity

    @Override
    public String takeUserDetails() {
        return name;
    } //same
}