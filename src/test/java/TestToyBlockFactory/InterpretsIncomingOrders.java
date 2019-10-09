import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InterpretsIncomingOrders {
    private ToyBlockFactory testFactory;
    private CustomerOrder testCustomerOrder;

    @Before
    public void init(){
        testFactory = new ToyBlockFactory();

        List<Blueprint> specification = new ArrayList<>();
        specification.add(new Blueprint(Color.BLUE, Shape.SQUARE, 2));
        Customer testCustomer = new Customer("Joe", "123 Test Street");
        testCustomerOrder = new CustomerOrder(testCustomer, java.util.Date.from(Instant.now()), 1, specification);
    }

    @Test
    public void createCuttingOrderFromCustomerOrder() {
        List<CuttingOrder> testCuttingOrder = testFactory.cuttingOrdersFromCustomerOrder(testCustomerOrder);

        Assert.assertEquals(2, testCuttingOrder.get(0).getQuantityToCut());
        Assert.assertEquals(Shape.SQUARE, testCuttingOrder.get(0).getShapeToCut());
    }

    @Test
    public void createPaintingOrderFromCustomerOrder() {
        List<Block> blockBatch = new ArrayList<>();
        blockBatch.add(new Block(Shape.SQUARE));
        blockBatch.add(new Block(Shape.SQUARE));
        List<PaintingOrder> testPaintingOrder = testFactory.paintingOrdersFromCustomerOrder(testCustomerOrder, blockBatch);

        Assert.assertEquals(Color.BLUE, testPaintingOrder.get(0).getColorToPaintBlocks());
        Assert.assertEquals(2, testPaintingOrder.get(0).getBlocksToPaint().size());
    }

}
