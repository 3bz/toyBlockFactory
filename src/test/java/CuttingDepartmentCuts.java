import services.factory.shaping.CuttingDepartment;
import services.factory.Block;
import services.factory.shaping.CuttingOrder;
import services.factory.shaping.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuttingDepartmentCuts {
    private CuttingDepartment testCut;
    private CuttingOrder testOrder;

    @Before
    public void init() {
        testCut = new CuttingDepartment();
    }

    @Test
    public void aSquareBlock(){
        testOrder = new CuttingOrder(Shape.SQUARE, 1);
        List<Block> testBlock = testCut.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.SQUARE, testBlock.get(0).getShape());
    }

    @Test
    public void aCircleBlock(){
        testOrder = new CuttingOrder(Shape.CIRCLE, 1);
        List<Block> testBlock = testCut.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.CIRCLE, testBlock.get(0).getShape());
    }

    @Test
    public void aTriangleBlock(){
        testOrder = new CuttingOrder(Shape.TRIANGLE, 1);
        List<Block> testBlock = testCut.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.TRIANGLE, testBlock.get(0).getShape());
    }

    @Test
    public void andReturnsManyBlocks() {
        testOrder = new CuttingOrder(Shape.SQUARE, 2);
        List<Block> testList = testCut.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(2, testList.size());
    }
}