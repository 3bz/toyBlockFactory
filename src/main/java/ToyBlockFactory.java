import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> requestShapesCut(List<CuttingOrder> listOfShapeOrders) {
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder differentShapeOrder : listOfShapeOrders)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(differentShapeOrder));

        return blocksCut;
    }

    public List<Block> requestBlocksPainted(List<PaintingOrder> listOfPaintingOrders) {
        List<Block> blocksPainted = new ArrayList<>();
        for (PaintingOrder differentColorOrder : listOfPaintingOrders)
            blocksPainted.addAll(paintingDepartment.fulfillPaintingOrder(differentColorOrder));

        return blocksPainted;
    }

    public List<CuttingOrder> cuttingOrdersFromCustomerOrder(CustomerOrder orderToProcess) {
        List<CuttingOrder> shapeRequests = new ArrayList<>();
        for (Blueprint individualBlockOrder : orderToProcess.getSpecification()) {
            Shape toBeCut = individualBlockOrder.getShapePlanned();
            int amount = individualBlockOrder.getQuantityOfBlock();

            shapeRequests.add(new CuttingOrder(toBeCut, amount));
        }
        return shapeRequests;
    }

    public List<PaintingOrder> paintingOrdersFromCustomerOrder(CustomerOrder orderToProcess, List<Block> newlyCutBlocks) {
        List<PaintingOrder> paintingRequests = new ArrayList<>();
        for (Color singleColor : Color.values()) {
            for (Blueprint singleSpecification : orderToProcess.getSpecification()) {
                if (singleColor.equals(singleSpecification.getColorPlanned())) {
                    List<Block> blockSet = new ArrayList<>();
                    blockSet.addAll(extractBlocks(singleSpecification, newlyCutBlocks));
                    paintingRequests.add(new PaintingOrder(singleColor, blockSet));
                }
            }
        }
        return paintingRequests;
    }

    private List<Block> extractBlocks(Blueprint requiredOrder, List<Block> blocksProvided) {
        List<Block> blockBatch = new ArrayList<>();
        for (int i = 0; i < requiredOrder.getQuantityOfBlock();) {
            for (Block singleBlock : blocksProvided) {
                if (singleBlock.getShape().equals(requiredOrder.getShapePlanned())) {
                    blockBatch.add(singleBlock);
                    i++;
                }
            }
        }
        return blockBatch;
    }
}