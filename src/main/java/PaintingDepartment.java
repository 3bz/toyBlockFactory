import java.util.ArrayList;
import java.util.List;

public class PaintingDepartment {
    private IPaintBlocks workers;

    public PaintingDepartment(){
        workers = new BlockPainter();
    }

    public List<Block> fullfilPaintingOrder(PaintingOrder aOrder) {
        List<Block> blocksPainted = new ArrayList<>();
        for (Block block : aOrder.getBlocksToPaint()) {
            blocksPainted.add(paintBlock(block, aOrder.getColorToPaintBlocks()));
        }
        return blocksPainted;
    }

    public Block paintBlock(Block aBlock, Color aColor) {
        return workers.paintBlock(aBlock, aColor);
    }
}
