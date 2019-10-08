import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestToyBlockFactory {
    private ToyBlockFactory testFactory;
    private List<CuttingOrder> cuttingOrder;
    private List<PaintingOrder> paintingOrder;

    @Before
    public void init(){
        testFactory = new ToyBlockFactory();

        cuttingOrder = new ArrayList<>();
        cuttingOrder.add(new CuttingOrder(Shape.SQUARE, 2));
        cuttingOrder.add(new CuttingOrder(Shape.CIRCLE, 3));
        cuttingOrder.add(new CuttingOrder(Shape.TRIANGLE, 1));

        paintingOrder = new ArrayList<>();
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(Shape.SQUARE));
        paintingOrder.add(new PaintingOrder(Color.RED, blockList));
    }

    @Test
    public void getManyDifferentBlocksCut() {
        List<Block> testShapesCut = testFactory.requestShapesCut(cuttingOrder);

        Assert.assertTrue(testShapesCut.size() == 6);
    }

    @Test
    public void returnsDifferentShapesInOrder() {
        List<Block> testShapesOrder = testFactory.requestShapesCut(cuttingOrder);
        Block actual = testShapesOrder.get(2);

        Assert.assertEquals(actual.getShape(), Shape.CIRCLE);
    }

    @Test
    public void paintAllBlocksInOrder() {
        Block blockBeforeBeingPainted = paintingOrder.get(0).getBlocksToPaint().get(0);
        Assert.assertEquals(Color.NATURAL, blockBeforeBeingPainted.getColor());

        List<Block> paintedBlocks = testFactory.requestBlocksPainted(paintingOrder);

        Assert.assertEquals(Color.RED, paintedBlocks.get(0).getColor());
    }

    @Test
    public void interpretCustomerOrderToCreateCuttingOrder() {
        List<Blueprint> specification = new ArrayList<Blueprint>();
        specification.add(new Blueprint(Color.BLUE, Shape.SQUARE, 2));
        Customer testCustomer = new Customer("Joe", "123 Test Street");

        CustomerOrder testCustomerOrder = new CustomerOrder(testCustomer, java.util.Date.from(Instant.now()), 1, specification);
        CuttingOrder testCuttingOrder = testFactory.createCuttingOrder(testCustomerOrder);

        Assert.assertEquals(2, testCuttingOrder.getQuantityToCut());
        Assert.assertEquals(Shape.SQUARE, testCuttingOrder.getShapeToCut());
    }
}
