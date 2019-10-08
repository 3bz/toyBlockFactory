public class CuttingOrder {
    private int quantityToCut;
    private Shape shapeToCut;

    public CuttingOrder(Shape aShape, int aQuantity){
        quantityToCut = aQuantity;
        shapeToCut = aShape;
    }

    public int getQuantityToCut() {
        return quantityToCut;
    }

    public Shape getShapeToCut() {
        return shapeToCut;
    }
}