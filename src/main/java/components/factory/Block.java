package components.factory;

import components.factory.paint.Color;
import components.factory.cut.Shape;

public class Block {
    private final Shape shape;
    private Color color;

    public Block(Shape blockShape) {
        shape = blockShape;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color aColor) {
        color = aColor;
    }
}