import java.util.List;

public class PaintingOrder {
    private Color colorToPaintBlocks;
    private List<Block> blocksToPaint;

    public PaintingOrder(Color aColor, List<Block> blocks) {
        colorToPaintBlocks = aColor;
        blocksToPaint = blocks;
    }

    public List<Block> getBlocksToPaint() {
        return blocksToPaint;
    }

    public Color getColorToPaintBlocks() {
        return colorToPaintBlocks;
    }
}

