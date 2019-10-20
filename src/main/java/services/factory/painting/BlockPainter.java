package services.factory.painting;

import services.factory.Block;

public class BlockPainter {

    public void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}