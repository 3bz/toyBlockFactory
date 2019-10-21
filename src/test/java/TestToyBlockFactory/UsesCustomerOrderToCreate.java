import services.factory.Block;
import services.factory.ToyBlockFactory;
import services.factory.painting.Color;
import services.factory.cutting.CuttingOrder;
import services.factory.painting.PaintingOrder;
import services.factory.cutting.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.Blueprint;
import services.ordering.Customer;
import services.ordering.CustomerOrder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UsesCustomerOrderToCreate {
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
    public void cuttingOrder() {
        List<CuttingOrder> testCuttingOrder = testFactory.createCuttingOrders(testCustomerOrder);

        Assert.assertEquals(2, testCuttingOrder.get(0).getQuantityToCut());
        Assert.assertEquals(Shape.SQUARE, testCuttingOrder.get(0).getShapeToCut());
    }

    @Test
    public void paintingOrder() {
        List<Block> blockBatch = new ArrayList<>();
        blockBatch.add(new Block(Shape.SQUARE));
        blockBatch.add(new Block(Shape.SQUARE));
        List<PaintingOrder> testPaintingOrder = testFactory.createPaintingOrders(testCustomerOrder, blockBatch);

        Assert.assertEquals(Color.BLUE, testPaintingOrder.get(0).getColorToPaintBlocks());
        Assert.assertEquals(2, testPaintingOrder.get(0).getBlocksToPaint().size());
    }

}