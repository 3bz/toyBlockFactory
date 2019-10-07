import java.util.ArrayList;
import java.util.List;

public class CuttingDepartment {
    private ICutShapes workers;

    public CuttingDepartment() {
        workers = new BlockCutter();
    }

    public List<Block> fulfillOrder(CuttingOrder aOrder) {
        List<Block> blocksMadeToOrder = new ArrayList<Block>();
        for (int quantity = 0; quantity < aOrder.getQuantityToCut(); quantity++)
            blocksMadeToOrder.add(cutShape(aOrder.getShapeToCut()));

        return blocksMadeToOrder;
    }

    private Block cutShape(Shape blockShape){
        return workers.cutBlock(blockShape);
    }
}
