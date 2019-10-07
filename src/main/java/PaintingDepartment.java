public class PaintingDepartment {
    private IPaintBlocks workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public void paintBlock(Block aBlock) {
        workers.paintBlock(aBlock, Color.RED);
    }
}
