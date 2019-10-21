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

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderOfOperations {
    private ToyBlockFactory factory;
    private CustomerOrder customerOrder;

    @Before
    public void init(){
        factory = new ToyBlockFactory();
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 3));
        customerOrder = new CustomerOrder(new Customer("test", "test"),
                Date.from(Instant.now()), 1, testSpec);
    }

    @Test
    public void cutsBlocksToSatisfyPaintingOrder() {
        List<CuttingOrder> cuttingOrders = factory.cuttingOrdersFromCustomerOrder(customerOrder);
        List<Block> newlyCutBlocks = factory.requestShapesCut(cuttingOrders);
        List<PaintingOrder> paintingOrders = factory.paintingOrdersFromCustomerOrder(customerOrder, newlyCutBlocks);
        factory.requestBlocksPainted(paintingOrders);
        List<Block> paintedBlocks = paintingOrders.get(0).getBlocksToPaint();

        Assert.assertEquals(Color.RED, paintedBlocks.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, paintedBlocks.get(0).getShape());
        Assert.assertEquals(3, paintedBlocks.size());
    }

    @Test
    public void analysesAndReturnsCompletedOrder() {
        List<Block> completedOrder = factory.processCustomerOrder(customerOrder);

        Assert.assertEquals(Color.RED, completedOrder.get(0).getColor());
        Assert.assertEquals(Shape.SQUARE, completedOrder.get(0).getShape());
        Assert.assertEquals(3, completedOrder.size());
    }
}