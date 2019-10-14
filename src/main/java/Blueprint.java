public class Blueprint {
    private final Color colorPlanned;
    private final Shape shapePlanned;
    private final int quantityOfBlock;

    public Blueprint(Color aColor, Shape aShape, int aQuantity) {
        colorPlanned = aColor;
        shapePlanned = aShape;
        quantityOfBlock = aQuantity;
    }

    public Color getColorPlanned() {
        return colorPlanned; }

    public Shape getShapePlanned() {
        return shapePlanned;
    }

    public int getQuantityOfBlock() {
        return quantityOfBlock;
    }
}