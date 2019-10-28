package components.factory.cut;

import components.factory.Block;

import java.util.ArrayList;
import java.util.List;

public class CuttingDepartment {
    private Cutter blockCutter;

    public CuttingDepartment() {
        blockCutter = new Cutter();
    } //fix

    public List<Block> fulfillCuttingOrder(CuttingOrder aOrder) {
        List<Block> blocksMadeToOrder = new ArrayList<>();
        for (int quantity = 0; quantity < aOrder.getQuantityToCut(); quantity++)
            blocksMadeToOrder.add(cutShape(aOrder.getShapeToCut()));

        return blocksMadeToOrder;
    }

    private Block cutShape(Shape blockShape){
        return blockCutter.cutBlock(blockShape);
    }
}