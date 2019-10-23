package components.factory.paint;

import components.factory.Block;

class Painter {

    void paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
    }
}