package services.factory.painting;

import services.factory.Block;

public class BlockPainter implements IPaintBlocks{

    @Override
    public void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}