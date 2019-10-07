import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestToyBlockFactory {
    private ToyBlockFactory testFactory;
    private List<CuttingOrder> cuttingOrder;

    @Before
    public void init(){
        testFactory = new ToyBlockFactory();
        cuttingOrder = new ArrayList<CuttingOrder>();
        cuttingOrder.add(new CuttingOrder(Shape.SQUARE, 2));
        cuttingOrder.add(new CuttingOrder(Shape.CIRCLE, 3));
        cuttingOrder.add(new CuttingOrder(Shape.TRIANGLE, 1));
    }

    @Test
    public void getManyDifferentBlocksCut() {
        List<Block> testList = testFactory.requestShapesCut(cuttingOrder);

        Assert.assertTrue(testList.size() == 6);
    }

    @Test
    public void returnsDifferentShapesInOrder() {
        List<Block> testList = testFactory.requestShapesCut(cuttingOrder);
        Block actual = testList.get(2);

        Assert.assertEquals(actual.getShape(), Shape.CIRCLE);
    }
}
