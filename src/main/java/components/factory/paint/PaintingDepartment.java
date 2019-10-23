package components.factory.paint;

import components.factory.Block;

public class PaintingDepartment {
    private Painter workers;

    public PaintingDepartment(){
        workers = new Painter();
    }

    public void fulfillPaintingOrder(PaintingOrder aOrder) {
        for (Block block : aOrder.getBlocksToPaint())
            workers.paintBlock(block, aOrder.getColorToPaintBlocks());
    }
}