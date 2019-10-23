package services.factory.cutting;

import services.factory.Block;

class Cutter {

    Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}