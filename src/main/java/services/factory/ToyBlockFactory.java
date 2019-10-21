package services.factory;

import services.factory.cutting.CuttingDepartment;
import services.factory.painting.PaintingDepartment;
import services.factory.painting.Color;
import services.factory.cutting.CuttingOrder;
import services.factory.painting.PaintingOrder;
import services.factory.cutting.Shape;
import services.ordering.Blueprint;
import services.ordering.CustomerOrder;

import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> processOrder(CustomerOrder customerOrder) {
        List<CuttingOrder> cuttingInstructions = createCuttingOrders(customerOrder);
        List<Block> blocksMadeToOrder = getCutBlocks(cuttingInstructions);
        List<PaintingOrder> paintingInstructions = createPaintingOrders(customerOrder, blocksMadeToOrder);
        getBlocksPainted(paintingInstructions);
        return bundleOrder(paintingInstructions);
    }

    public List<CuttingOrder> createCuttingOrders(CustomerOrder orderToProcess) {
        List<CuttingOrder> shapeRequirements = new ArrayList<>();
        for (Blueprint individualBlockOrder : orderToProcess.getSpecification()) {
            Shape shapeToCut = individualBlockOrder.getShapePlanned();
            int amount = individualBlockOrder.getQuantity();

            shapeRequirements.add(new CuttingOrder(shapeToCut, amount));
        }
        return shapeRequirements;
    }

    public List<Block> getCutBlocks(List<CuttingOrder> shapeOrders) {
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder singleShapeOrder : shapeOrders)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(singleShapeOrder));

        return blocksCut;
    }

    public List<PaintingOrder> createPaintingOrders(CustomerOrder orderToProcess, List<Block> availableBlocks) {
        List<PaintingOrder> paintingRequests = new ArrayList<>();
        for (Color singleColor : Color.values()) {
            for (Blueprint singleOrder : orderToProcess.getSpecification()) {
                if (singleColor.equals(singleOrder.getColorPlanned())) {
                    List<Block> blockNeeded = extractBlocks(singleOrder, availableBlocks);
                    paintingRequests.add(new PaintingOrder(singleColor, blockNeeded));
                }
            }
        }
        return paintingRequests;
    }

    private List<Block> extractBlocks(Blueprint specificOrder, List<Block> blocksProvided) {
        List<Block> blocksForOrder = new ArrayList<>();
        int quantityMet = 0;
        for (Block singleBlock : blocksProvided) {
            if (quantityMet < specificOrder.getQuantity()) {
                if (singleBlock.getShape().equals(specificOrder.getShapePlanned())) {
                    blocksForOrder.add(singleBlock);
                    quantityMet++;
                }
            }
        }
        return blocksForOrder;
    }

    public void getBlocksPainted(List<PaintingOrder> paintOrders) {
        for (PaintingOrder differentColorRequested : paintOrders)
            paintingDepartment.fulfillPaintingOrder(differentColorRequested);

    }

    private List<Block> bundleOrder(List<PaintingOrder> paintedBlocks) {
        List<Block> completedOrder = new ArrayList<>();
        for (PaintingOrder singleOrder : paintedBlocks)
            completedOrder.addAll(singleOrder.getBlocksToPaint());
        return completedOrder;
    }
}