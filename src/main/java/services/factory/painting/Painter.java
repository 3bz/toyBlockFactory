package services.factory.painting;

import services.factory.Block;

class Painter {

    void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}