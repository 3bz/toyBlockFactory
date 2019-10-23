import components.factory.Block;
import components.factory.ToyBlockFactory;
import components.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import components.factory.paint.Color;
import components.order.Blueprint;
import components.order.Customer;
import components.order.CustomerOrder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManufactureBasedOnBlueprints {
    private ToyBlockFactory testFactory;
    private CustomerOrder testOrder;

    @Before
    public void init(){
        Customer customer = new Customer("test", "test");
        Date date = Date.from(Instant.now());
        int orderNo = 1;

        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 2));
        testSpec.add(new Blueprint(Color.BLUE, Shape.CIRCLE, 3));
        testSpec.add(new Blueprint(Color.YELLOW, Shape.TRIANGLE, 2));

        testOrder = new CustomerOrder(customer, date, orderNo, testSpec);
        testFactory = new ToyBlockFactory();
    }

    @Test
    public void differentShapesCutInSingleOrder() {
        List<Block> shapesCut = testFactory.startCuttingProcedure(testOrder);

        Assert.assertEquals(7, shapesCut.size());
    }

    @Test
    public void useCutBlocksInPaintingProcess() {
        List<Block> blocksCut = testFactory.startCuttingProcedure(testOrder);
        List<Block> paintedBlocks = testFactory.startPaintingProcedure(testOrder, blocksCut);

        Assert.assertEquals(Color.RED, paintedBlocks.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, paintedBlocks.get(0).getShape());
    }

//    @Test(expected=IllegalStateException.class)
//    public void notSuppliedEnoughBlocksForOrderRequirement() {
//        List<Block> insufficientBlocks = new ArrayList<>();
//        List<Block> attemptedBlocks = testFactory.paintingProcedure(testOrder, insufficientBlocks);
//    }

    @Test
    public void satisfiesAndReturnsCompletedOrder() {
        List<Block> completedOrder = testFactory.processOrder(testOrder);

        Assert.assertEquals(Color.RED, completedOrder.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, completedOrder.get(0).getShape());
        Assert.assertEquals(7, completedOrder.size());
    }
}