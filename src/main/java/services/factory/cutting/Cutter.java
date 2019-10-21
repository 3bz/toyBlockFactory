package services.factory.cutting;

import services.factory.Block;

public class Cutter {

    public Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}