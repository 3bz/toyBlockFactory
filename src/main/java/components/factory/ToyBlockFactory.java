package components.factory;

import components.factory.cut.CuttingDepartment;
import components.factory.paint.PaintingDepartment;
import components.factory.paint.Color;
import components.factory.cut.CuttingOrder;
import components.factory.paint.PaintingOrder;
import components.factory.cut.Shape;
import components.order.Blueprint;
import components.order.CustomerOrder;

import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> processBlockOrder(CustomerOrder customerOrder) {
        List <Block> freshlyCutBlocks = startCuttingProcedure(customerOrder);

        return startPaintingProcedure(customerOrder, freshlyCutBlocks);
    }

    public List<Block> startCuttingProcedure(CustomerOrder customerOrder) {
        List<CuttingOrder> cuttingInstructions = createCuttingOrders(customerOrder);
        return getCutBlocks(cuttingInstructions);
    }

    private List<CuttingOrder> createCuttingOrders(CustomerOrder orderToProcess) {
        List<CuttingOrder> cuttingInstructions = new ArrayList<>();
        for (Blueprint singleBlockOrder : orderToProcess.getBlueprints()) {
            Shape shapeToCut = singleBlockOrder.getShapePlanned();
            int amount = singleBlockOrder.getQuantityPlanned();

            cuttingInstructions.add(new CuttingOrder(shapeToCut, amount));
        }
        return cuttingInstructions;
    }

    private List<Block> getCutBlocks(List<CuttingOrder> cuttingInstructions) {
        List<Block> cutBlocks = new ArrayList<>();
        for (CuttingOrder singleShape : cuttingInstructions)
            cutBlocks.addAll(cuttingDepartment.fulfillCuttingOrder(singleShape));

        return cutBlocks;
    }

    public List<Block> startPaintingProcedure(CustomerOrder customerOrder, List<Block> blocksProvided) {
        List<PaintingOrder> paintingInstructions = createPaintingOrders(customerOrder, blocksProvided);
        paintBlocks(paintingInstructions);
        return bundleOrder(paintingInstructions);
    }

    private List<PaintingOrder> createPaintingOrders(CustomerOrder orderToProcess, List<Block> blocksProvided) {
        List<PaintingOrder> paintingInstructions = new ArrayList<>();
        for (Color individualColor : Color.values()) {
            for (Blueprint singleOrder : orderToProcess.getBlueprints()) {
                if (individualColor.equals(singleOrder.getColorPlanned())) {
                    List<Block> blocksNeeded = extractBlocks(singleOrder, blocksProvided);
                    paintingInstructions.add(new PaintingOrder(individualColor, blocksNeeded));
                }
            }
        }
        return paintingInstructions;
    }

    private List<Block> extractBlocks(Blueprint specificOrder, List<Block> blocksProvided) {
        List<Block> blocksNeeded = new ArrayList<>();
        int quantityMet = 0;
        for (Block singleBlock : blocksProvided) {
            if (quantityMet < specificOrder.getQuantityPlanned()) {
                if ( (singleBlock.getShape().equals(specificOrder.getShapePlanned()))
                && (!blocksNeeded.contains(singleBlock)) ) {
                    blocksNeeded.add(singleBlock);
                    quantityMet++;
                }
            }
        }
        return blocksNeeded;
    }

    private void paintBlocks(List<PaintingOrder> paintingInstructions) {
        for (PaintingOrder differentColorRequested : paintingInstructions)
            paintingDepartment.fulfillPaintingOrder(differentColorRequested);
    }

    private List<Block> bundleOrder(List<PaintingOrder> paintedBlocks) {
        List<Block> completedOrder = new ArrayList<>();
        for (PaintingOrder singleOrder : paintedBlocks)
            completedOrder.addAll(singleOrder.getBlocksToPaint());
        return completedOrder;
    }
}