package services.factory.model;

public class CuttingOrder {
    private Shape shapeToCut;
    private int quantityToCut;

    public CuttingOrder(Shape aShape, int aQuantity) {
        quantityToCut = aQuantity;
        shapeToCut = aShape;
    }

    public Shape getShapeToCut() {
        return shapeToCut;
    }

    public int getQuantityToCut() {
        return quantityToCut;
    }
}