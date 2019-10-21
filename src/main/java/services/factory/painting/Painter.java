package services.factory.painting;

import services.factory.Block;

public class Painter {

    public void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}