public enum Shape {
    SQUARE(1, 1),
    TRIANGLE(2, 2),
    CIRCLE(3, 2);

    private int price;
    private final int index;

    Shape(int price, int index) {
        this.price = price;
        this.index = index;
    }

    public int getPrice() {
        return price;
    }

    public int getIndex() {
        return index;
    }
}