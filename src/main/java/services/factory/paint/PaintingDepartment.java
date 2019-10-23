package services.factory.paint;

import services.factory.Block;

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