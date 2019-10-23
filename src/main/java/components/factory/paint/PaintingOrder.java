package components.factory.paint;

import components.factory.Block;

import java.util.List;

public class PaintingOrder {
    private Color colorToPaintBlocks;
    private List<Block> blocksToPaint;

    public PaintingOrder(Color aColor, List<Block> blocks) {
        colorToPaintBlocks = aColor;
        blocksToPaint = blocks;
    }

    Color getColorToPaintBlocks() {
        return colorToPaintBlocks;
    }

    public List<Block> getBlocksToPaint() {
        return blocksToPaint;
    }
}