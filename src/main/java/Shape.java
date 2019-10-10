public enum Shape {
    SQUARE(1),
    TRIANGLE(2),
    CIRCLE(3);

    private int price;

    Shape(int i) {
        this.price = i;
    }

    public int getPrice() {
        return price;
    }
}