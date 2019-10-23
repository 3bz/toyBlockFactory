package services.factory;

import services.factory.cutting.CuttingDepartment;
import services.factory.painting.PaintingDepartment;
import services.factory.painting.Color;
import services.factory.cutting.CuttingOrder;
import services.factory.painting.PaintingOrder;
import services.factory.cutting.Shape;
import services.ordering.Blueprint;
import services.ordering.CustomerOrder;

import javax.naming.InsufficientResourcesException;
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
        List <Block> blocksCutForOrder = cuttingProcedure(customerOrder);

        return paintingProcedure(customerOrder, blocksCutForOrder);
    }

    public List<Block> cuttingProcedure(CustomerOrder customerOrder) {
        List<CuttingOrder> cuttingInstructions = createCuttingOrders(customerOrder);
        return getCutBlocks(cuttingInstructions);
    }

    public List<Block> paintingProcedure(CustomerOrder customerOrder, List<Block> blocksProvided) {
        List<Block> customerBlocks = new ArrayList<>();
        try {
            List<PaintingOrder> paintingInstructions = createPaintingOrders(customerOrder, blocksProvided);
            paintBlocks(paintingInstructions);
            customerBlocks = bundleOrder(paintingInstructions);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return customerBlocks;
    }

    private List<CuttingOrder> createCuttingOrders(CustomerOrder orderToProcess) {
        List<CuttingOrder> shapeRequirements = new ArrayList<>();
        for (Blueprint individualBlockOrder : orderToProcess.getSpecification()) {
            Shape shapeToCut = individualBlockOrder.getShapePlanned();
            int amount = individualBlockOrder.getQuantity();

            shapeRequirements.add(new CuttingOrder(shapeToCut, amount));
        }
        return shapeRequirements;
    }

    private List<Block> getCutBlocks(List<CuttingOrder> shapeOrders) {
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder singleShapeOrder : shapeOrders)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(singleShapeOrder));

        return blocksCut;
    }

    private List<PaintingOrder> createPaintingOrders(CustomerOrder orderToProcess, List<Block> blocksProvided) throws IllegalStateException {
        List<PaintingOrder> paintingRequests = new ArrayList<>();
        for (Color singleColor : Color.values()) {
            for (Blueprint singleOrder : orderToProcess.getSpecification()) {
                if (singleColor.equals(singleOrder.getColorPlanned())) {
                    if (isEnoughBlocksToSatisfyRequirement(singleOrder, blocksProvided)) {
                        List<Block> blockNeeded = extractBlocks(singleOrder, blocksProvided);
                        paintingRequests.add(new PaintingOrder(singleColor, blockNeeded));
                    }
                    else
                        throw new IllegalStateException("Not enough blocks cut to satisfy order requirement");
                }
            }
        }
        return paintingRequests;
    }

    private void paintBlocks(List<PaintingOrder> paintOrders) {
        for (PaintingOrder differentColorRequested : paintOrders)
            paintingDepartment.fulfillPaintingOrder(differentColorRequested);
    }

    private boolean isEnoughBlocksToSatisfyRequirement(Blueprint requirement, List<Block> blocks) {
        int quantityMet = 0;
        for (Block block: blocks) {
            if (requirement.getShapePlanned().equals(block.getShape()))
                quantityMet++;
        }
        return (quantityMet >= requirement.getQuantity());
    }

    private List<Block> extractBlocks(Blueprint specificOrder, List<Block> blocksProvided) {
        List<Block> blocksForOrder = new ArrayList<>();
        int quantityMet = 0;
        for (Block singleBlock : blocksProvided) {
            if (quantityMet < specificOrder.getQuantity()) {
                if ( (singleBlock.getShape().equals(specificOrder.getShapePlanned()))
                && (!blocksForOrder.contains(singleBlock)) ) {
                    blocksForOrder.add(singleBlock);
                    quantityMet++;
                }
            }
        }
        return blocksForOrder;
    }

    private List<Block> bundleOrder(List<PaintingOrder> paintedBlocks) {
        List<Block> completedOrder = new ArrayList<>();
        for (PaintingOrder singleOrder : paintedBlocks)
            completedOrder.addAll(singleOrder.getBlocksToPaint());
        return completedOrder;
    }
}