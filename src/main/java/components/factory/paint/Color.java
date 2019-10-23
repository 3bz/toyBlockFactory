package components.factory.paint;

public enum Color {
    RED(1),
    BLUE(0),
    YELLOW(0);

    private int surcharge;

    Color(int surcharge) {
        this.surcharge = surcharge;
    }

    public int getPrice() {
        return surcharge;
    }
}