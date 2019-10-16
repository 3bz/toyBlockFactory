package services.factory.mutation;

import services.factory.Block;
import services.factory.model.Color;

public interface IPaintBlocks {
    void paintBlock(Block aBlock, Color aColor);
}