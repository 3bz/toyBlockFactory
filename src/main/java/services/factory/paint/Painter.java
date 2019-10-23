package services.factory.paint;

import services.factory.Block;

class Painter {

    void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}