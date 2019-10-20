package services.factory.painting;

import services.factory.Block;

public class PaintingDepartment {
    private BlockPainter workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public void fulfillPaintingOrder(PaintingOrder aOrder) {
        for (Block block : aOrder.getBlocksToPaint())
            workers.paintBlock(block, aOrder.getColorToPaintBlocks());
    }
}