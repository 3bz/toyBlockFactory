public class CuttingOrder {
    private Shape shapeToCut;
    private int quantityToCut;

    public CuttingOrder(Shape aShape, int aQuantity){
        shapeToCut = aShape;
        quantityToCut = aQuantity;
    }

    public Shape getShapeToCut() {
        return shapeToCut;
    }

    public int getQuantityToCut() {
        return quantityToCut;
    }
}
