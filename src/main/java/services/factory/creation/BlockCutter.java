package services.factory.creation;

import services.factory.Block;
import services.factory.model.Shape;

public class BlockCutter implements ICutShapes {

    @Override
    public Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}