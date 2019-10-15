import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> processCustomerOrder(CustomerOrder customerOrder) {
        List<CuttingOrder> cuttingOrders = cuttingOrdersFromCustomerOrder(customerOrder);
        List<Block> blocksMadeToOrder = requestShapesCut(cuttingOrders);
        List<PaintingOrder> paintingOrders = paintingOrdersFromCustomerOrder(customerOrder, blocksMadeToOrder);
        requestBlocksPainted(paintingOrders);
        return bundleOrder(paintingOrders);
    }

    public List<CuttingOrder> cuttingOrdersFromCustomerOrder(CustomerOrder orderToProcess) {
        List<CuttingOrder> shapeRequests = new ArrayList<>();
        for (Blueprint individualBlockOrder : orderToProcess.getSpecification()) {
            Shape toBeCut = individualBlockOrder.getShapePlanned();
            int amount = individualBlockOrder.getQuantity();

            shapeRequests.add(new CuttingOrder(toBeCut, amount));
        }
        return shapeRequests;
    }

    public List<Block> requestShapesCut(List<CuttingOrder> listOfShapeOrders) {
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder differentShapeOrder : listOfShapeOrders)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(differentShapeOrder));

        return blocksCut;
    }

    public List<PaintingOrder> paintingOrdersFromCustomerOrder(CustomerOrder orderToProcess, List<Block> availableBlocks) {
        List<PaintingOrder> paintingRequests = new ArrayList<>();
        for (Color singleColor : Color.values()) {
            for (Blueprint singleSpecification : orderToProcess.getSpecification()) {
                if (singleColor.equals(singleSpecification.getColorPlanned())) {
                    List<Block> blockNeeded = extractBlocks(singleSpecification, availableBlocks);
                    paintingRequests.add(new PaintingOrder(singleColor, blockNeeded));
                }
            }
        }
        return paintingRequests;
    }

    private List<Block> extractBlocks(Blueprint specificOrder, List<Block> blocksProvided) {
        List<Block> blocksForOrder = new ArrayList<>();
        for (int i = 0; i < specificOrder.getQuantity();) {
            for (Block singleBlock : blocksProvided) {
                if (singleBlock.getShape().equals(specificOrder.getShapePlanned())) {
                    blocksForOrder.add(singleBlock);
                    i++;
                }
            }
        }
        return blocksForOrder;
    }

    public void requestBlocksPainted(List<PaintingOrder> listOfPaintingOrders) {
        for (PaintingOrder differentColorRequested : listOfPaintingOrders)
            paintingDepartment.fulfillPaintingOrder(differentColorRequested);

    }

    private List<Block> bundleOrder(List<PaintingOrder> paintedBlocks) {
        List<Block> completedOrder = new ArrayList<>();
        for (PaintingOrder singleOrder : paintedBlocks)
            completedOrder.addAll(singleOrder.getBlocksToPaint());
        return completedOrder;
    }
}