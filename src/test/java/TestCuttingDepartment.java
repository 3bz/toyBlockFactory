import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCuttingDepartment {
    private CuttingDepartment testCut;

    @Before
    public void init() {
        testCut = new CuttingDepartment();
    }

    @Test
    public void cutsSquareBlock(){
        List<Block> testBlock = testCut.fulfillOrder(new CuttingOrder(Shape.SQUARE, 1));

        Assert.assertTrue(testBlock.get(0).getShape().equals(Shape.SQUARE));
    }

    @Test
    public void cutsCircleBlock(){
        List<Block> testBlock = testCut.fulfillOrder(new CuttingOrder(Shape.CIRCLE, 1));

        Assert.assertTrue(testBlock.get(0).getShape().equals(Shape.CIRCLE));
    }

    @Test
    public void cutsTriangleBlock(){
        List<Block> testBlock = testCut.fulfillOrder(new CuttingOrder(Shape.TRIANGLE,1 ));

        Assert.assertTrue(testBlock.get(0).getShape().equals(Shape.TRIANGLE));
    }

    @Test
    public void returnsManyBlocks() {
        CuttingOrder order = new CuttingOrder(Shape.SQUARE, 2);

        List<Block> testList = testCut.fulfillOrder(order);

        Assert.assertTrue(testList.size() == 2);
    }

//    @Test
//    public void returnsManyDifferentBlockShapes() {
//        List<CuttingOrder> order = new ArrayList<CuttingOrder>();
//        order.add(new CuttingOrder(Shape.SQUARE, 2));
//        order.add(new CuttingOrder(Shape.CIRCLE, 3));
//        order.add(new CuttingOrder(Shape.TRIANGLE, 1));
//
//        List<Block> testList = testCut.fulfillOrder(order);
//
//        Assert.assertTrue(testList.size() == 6);
//    }
//
//    @Test
//    public void returnsDifferentShapesInOrder() {
//        List<CuttingOrder> order = new ArrayList<CuttingOrder>();
//        order.add(new CuttingOrder(Shape.SQUARE, 2));
//        order.add(new CuttingOrder(Shape.CIRCLE, 3));
//        order.add(new CuttingOrder(Shape.TRIANGLE, 1));
//
//        List<Block> testList = testCut.fulfillOrder(order);
//        Block actual = testList.get(2);
//
//        Assert.assertEquals(actual.getShape(), Shape.CIRCLE);
//    }
}
