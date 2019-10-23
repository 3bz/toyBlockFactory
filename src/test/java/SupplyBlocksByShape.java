import components.factory.cut.CuttingDepartment;
import components.factory.Block;
import components.factory.cut.CuttingOrder;
import components.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SupplyBlocksByShape {
    private CuttingDepartment cuttingDept;
    private CuttingOrder testOrder;

    @Before
    public void init() {
        cuttingDept = new CuttingDepartment();
    }

    @Test
    public void aSquareBlock(){
        testOrder = new CuttingOrder(Shape.SQUARE, 1);
        List<Block> testBlock = cuttingDept.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.SQUARE, testBlock.get(0).getShape());
    }

    @Test
    public void aCircleBlock(){
        testOrder = new CuttingOrder(Shape.CIRCLE, 1);
        List<Block> testBlock = cuttingDept.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.CIRCLE, testBlock.get(0).getShape());
    }

    @Test
    public void aTriangleBlock(){
        testOrder = new CuttingOrder(Shape.TRIANGLE, 1);
        List<Block> testBlock = cuttingDept.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(Shape.TRIANGLE, testBlock.get(0).getShape());
    }

    @Test
    public void manyBlocksWithSameShape() {
        testOrder = new CuttingOrder(Shape.SQUARE, 2);
        List<Block> testList = cuttingDept.fulfillCuttingOrder(testOrder);

        Assert.assertEquals(2, testList.size());
    }
}