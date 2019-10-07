public class BlockPainter implements IPaintBlocks{

    @Override
    public Block paintBlock(Block aBlock, Color aColor) {
        aBlock.setColor(aColor);
        return aBlock;
    }
}
