import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuttingDepartmentCuts {
    private CuttingDepartment testCut;

    @Before
    public void init() {
        testCut = new CuttingDepartment();
    }

    @Test
    public void aSquareBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.SQUARE, 1));

        Assert.assertEquals(Shape.SQUARE, testBlock.get(0).getShape());
    }

    @Test
    public void aCircleBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.CIRCLE, 1));

        Assert.assertEquals(Shape.CIRCLE, testBlock.get(0).getShape());
    }

    @Test
    public void aTriangleBlock(){
        List<Block> testBlock = testCut.fulfillCuttingOrder(new CuttingOrder(Shape.TRIANGLE,1 ));

        Assert.assertEquals(Shape.TRIANGLE, testBlock.get(0).getShape());
    }

    @Test
    public void andReturnsManyBlocks() {
        CuttingOrder order = new CuttingOrder(Shape.SQUARE, 2);

        List<Block> testList = testCut.fulfillCuttingOrder(order);

        Assert.assertEquals(2, testList.size());
    }
}