package services.factory.cut;

public class CuttingOrder {
    private Shape shapeToCut;
    private int quantityToCut;

    public CuttingOrder(Shape aShape, int aQuantity) {
        shapeToCut = aShape;
        quantityToCut = aQuantity;
    }

    Shape getShapeToCut() {
        return shapeToCut;
    }

    int getQuantityToCut() {
        return quantityToCut;
    }
}