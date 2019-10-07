public class PaintingDepartment {
    private IPaintBlocks workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public void paintBlock(Block aBlock, Color aColor) {
        workers.paintBlock(aBlock, aColor);
    }
}
