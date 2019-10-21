import services.factory.Block;
import services.factory.ToyBlockFactory;
import services.factory.cutting.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.factory.painting.Color;
import services.ordering.Blueprint;
import services.ordering.Customer;
import services.ordering.CustomerOrder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InteractionBetweenDepartments {
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
    public void manyDifferentShapesCut() {
        List<Block> shapesCut = testFactory.cuttingProcedure(testOrder);

        Assert.assertEquals(7, shapesCut.size());
    }

    @Test
    public void shapesInSpecifiedArrangement() {
        List<Block> testShapesOrder = testFactory.cuttingProcedure(testOrder);
        Block actual = testShapesOrder.get(2);

        Assert.assertEquals(Shape.CIRCLE, actual.getShape());
    }

    @Test
    public void cutsBlocksToSatisfyPaintingOrder() {
        List<Block> blocksCut = testFactory.cuttingProcedure(testOrder);
        List<Block> paintedBlocks = testFactory.paintingProcedure(testOrder, blocksCut);

        Assert.assertEquals(Color.RED, paintedBlocks.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, paintedBlocks.get(0).getShape());
    }

    @Test
    public void analysesAndReturnsCompletedOrder() {
        List<Block> completedOrder = testFactory.processOrder(testOrder);

        Assert.assertEquals(Color.RED, completedOrder.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, completedOrder.get(0).getShape());
        Assert.assertEquals(7, completedOrder.size());
    }
}