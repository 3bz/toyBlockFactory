package services.factory.shaping;

import services.factory.Block;

public class BlockCutter implements ICutShapes {

    @Override
    public Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}