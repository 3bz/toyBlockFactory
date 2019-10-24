package components.order;

import components.factory.paint.Color;
import components.factory.cut.Shape;

public class Blueprint {
    private final Color colorPlanned;
    private final Shape shapePlanned;
    private final int quantityPlanned;

    public Blueprint(Color aColor, Shape aShape, int aQuantity) {
        colorPlanned = aColor;
        shapePlanned = aShape;
        quantityPlanned = aQuantity;
    }

    public Color getColorPlanned() {
        return colorPlanned;
    }

    public Shape getShapePlanned() {
        return shapePlanned;
    }

    public int getQuantityPlanned() {
        return quantityPlanned;
    }
}