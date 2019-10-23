package components.factory.cut;

import components.factory.Block;

class Cutter {

    Block cutBlock(Shape blockShape) {
        return new Block(blockShape);
    }
}