import io.Input;

public class StubInput implements Input {
    private String name;
    private int orderQuantity;

    public StubInput(String aName, int aOrderQuantity) {
        name = aName;
        orderQuantity = aOrderQuantity;
    }

    @Override
    public int takeInteger() {
        return orderQuantity;
    }

    @Override
    public String takeString() {
        return name;
    }
}