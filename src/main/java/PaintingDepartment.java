import java.util.List;

public class PaintingDepartment {
    private IPaintBlocks workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public void paintBlock(List<Block> blocks, Color aColor) {
        for (Block block : blocks)
            workers.paintBlock(block, aColor);
    }
}
