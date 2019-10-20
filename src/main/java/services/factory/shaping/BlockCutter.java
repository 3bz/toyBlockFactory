package services.factory.shaping;

import services.factory.Block;

public class BlockCutter {

    public Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}