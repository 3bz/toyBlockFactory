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

    public List<CuttingOrder> processOrderForCutting(CustomerOrder orderToProcess) {
        List<CuttingOrder> shapeRequests = new ArrayList<>();
        for (Blueprint individualBlockOrder : orderToProcess.getSpecification()) {
            Shape toBeCut = individualBlockOrder.getShapePlanned();
            int amount = individualBlockOrder.getQuantityOfBlock();

            shapeRequests.add(createCuttingOrder(toBeCut, amount));
        }
        return shapeRequests;
    }

    private CuttingOrder createCuttingOrder(Shape shapeToCut, int quantityToCut) {
        CuttingOrder newOrder = new CuttingOrder(shapeToCut, quantityToCut);
        return newOrder;
    }

}