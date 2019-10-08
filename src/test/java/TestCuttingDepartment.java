import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestCuttingDepartment {
    private CuttingDepartment testCut;

    @Before
    public void init() {
        testCut = new CuttingDepartment();
    }

    @Test
    public void cutsSquareBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.SQUARE, 1));

        Assert.assertEquals(Shape.SQUARE, testBlock.get(0).getShape());
    }

    @Test
    public void cutsCircleBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.CIRCLE, 1));

        Assert.assertEquals(Shape.CIRCLE, testBlock.get(0).getShape());
    }

    @Test
    public void cutsTriangleBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.TRIANGLE,1 ));

        Assert.assertEquals(Shape.TRIANGLE, testBlock.get(0).getShape());
    }

    @Test
    public void returnsManyBlocks() {
        CuttingOrder order = new CuttingOrder(Shape.SQUARE, 2);

        List<Block> testList = testCut.fulfillCuttingOrder(order);

        Assert.assertEquals(2, testList.size());
    }
}