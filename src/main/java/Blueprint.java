public class Blueprint {
    private final Color colorPlanned;
    private final Shape shapePlanned;
    private final int quantity;

    public Blueprint(Color aColor, Shape aShape, int aQuantity) {
        colorPlanned = aColor;
        shapePlanned = aShape;
        quantity = aQuantity;
    }

    public Color getColorPlanned() {
        return colorPlanned;
    }

    public Shape getShapePlanned() {
        return shapePlanned;
    }

    public int getQuantity() {
        return quantity;
    }
}