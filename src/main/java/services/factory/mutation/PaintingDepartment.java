package services.factory.mutation;

import services.factory.Block;
import services.factory.model.PaintingOrder;

public class PaintingDepartment {
    private IPaintBlocks workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public void fulfillPaintingOrder(PaintingOrder aOrder) {
        for (Block block : aOrder.getBlocksToPaint())
            workers.paintBlock(block, aOrder.getColorToPaintBlocks());
    }
}