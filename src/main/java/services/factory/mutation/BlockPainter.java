package services.factory.mutation;

import services.factory.Block;
import services.factory.model.Color;

public class BlockPainter implements IPaintBlocks{

    @Override
    public void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}