package services.factory.creation;

import services.factory.Block;
import services.factory.model.Shape;

public interface ICutShapes {
    Block cutBlock(Shape blockShape);
}