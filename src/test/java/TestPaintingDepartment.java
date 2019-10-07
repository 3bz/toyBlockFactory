import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPaintingDepartment {
    private PaintingDepartment testPaint;
    private PaintingOrder testOrder;

    @Before
    public void init(){
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(Shape.SQUARE));
        testPaint = new PaintingDepartment();
        testOrder = new PaintingOrder(Color.RED, blockList);
        testOrder.getBlocksToPaint().add(new Block(Shape.SQUARE));
    }

    @Test
    public void paintSingleBlock() {
        testPaint.fullfilPaintingOrder(testOrder);

        Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void paintManyBlocks() {
        for (int i = 0; i < 5; i++)
            testOrder.getBlocksToPaint().add(new Block(Shape.SQUARE));

        testPaint.fullfilPaintingOrder(testOrder);

        for (int j = 0; j < testOrder.getBlocksToPaint().size(); j++)
            Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(j).getColor());
    }

    @Test
    public void paintDifferentShapesSameColor() {
        testOrder.getBlocksToPaint().add(new Block(Shape.CIRCLE));
        testOrder.getBlocksToPaint().add(new Block(Shape.TRIANGLE));

        testPaint.fullfilPaintingOrder(testOrder);

        for (int i = 0; i < testOrder.getBlocksToPaint().size(); i++)
            Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(i).getColor());
    }
}
