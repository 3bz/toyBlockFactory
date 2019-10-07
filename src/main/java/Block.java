public class Block {
    private Shape shape;
    private Color color;

    public Block(Shape blockShape){
        shape = blockShape;
        color = Color.NATURAL;
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
