package components.factory.paint;

import components.factory.Block;

public class PaintingDepartment {
    private Painter blockPainter;

    public PaintingDepartment(){
        blockPainter = new Painter();
    }

    public void fulfillPaintingOrder(PaintingOrder aOrder) {
        for (Block block : aOrder.getBlocksToPaint())
            blockPainter.paintBlock(block, aOrder.getColorToPaintBlocks());
    }
}