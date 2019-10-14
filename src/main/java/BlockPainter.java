public class BlockPainter implements IPaintBlocks{

    @Override
    public void paintBlock(Block aBlock, Color aColor) { aBlock.setColor(aColor); }
}