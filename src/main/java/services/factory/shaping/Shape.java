package services.factory.shaping;

public enum Shape {
    SQUARE(1),
    TRIANGLE(2),
    CIRCLE(3);

    private final int price;

    Shape(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}