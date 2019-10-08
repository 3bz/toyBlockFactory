import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> requestShapesCut(List<CuttingOrder> listOfShapeOrders){
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder differentShapeOrder : listOfShapeOrders)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(differentShapeOrder));

        return blocksCut;
    }

    public List<Block> requestBlocksPainted(List<PaintingOrder> listOfPaintingOrders) {
        List<Block> blocksPainted = new ArrayList<>();
        for(PaintingOrder differentColorOrder : listOfPaintingOrders)
            blocksPainted.addAll(paintingDepartment.fulfillPaintingOrder(differentColorOrder));

        return blocksPainted;
    }

    public CuttingOrder createCuttingOrder(CustomerOrder orderToProcess) {
        Shape shapeToCut = orderToProcess.getSpecification().get(0).getShapePlanned();
        int quantityToCut = orderToProcess.getSpecification().get(0).getQuantityOfBlock();
        CuttingOrder newOrder = new CuttingOrder(shapeToCut, quantityToCut);
        return newOrder;
    }

    //MUST CONVERT CUSTOMER ORDER TO Cutting Orders and Painting Orders
}

