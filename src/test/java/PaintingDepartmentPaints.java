import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPaintingDepartment {
    private PaintingDepartment testPaintDept;
    private PaintingOrder testOrder;
    private List<Block> blockList;

    @Before
    public void init(){
        blockList = new ArrayList<>();
        blockList.add(new Block(Shape.SQUARE));
        testPaintDept = new PaintingDepartment();
    }

    @Test
    public void paintsRedBlock() {
        testOrder = new PaintingOrder(Color.RED, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void paintsBlueBlock() {
        testOrder = new PaintingOrder(Color.BLUE, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.BLUE, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void paintsYellowBlock() {
        testOrder = new PaintingOrder(Color.YELLOW, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.YELLOW, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void paintManyBlocks() {
        testOrder = new PaintingOrder(Color.RED, blockList);
        for (int i = 0; i < 5; i++)
            testOrder.getBlocksToPaint().add(new Block(Shape.CIRCLE));

        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertTrue(isCollectionPainted(Color.RED, testOrder.getBlocksToPaint()));
    }

    @Test
    public void paintDifferentShapesSameColor() {
        testOrder = new PaintingOrder(Color.RED, blockList);
        testOrder.getBlocksToPaint().add(new Block(Shape.CIRCLE));
        testOrder.getBlocksToPaint().add(new Block(Shape.TRIANGLE));

        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertTrue(isCollectionPainted(Color.RED, testOrder.getBlocksToPaint()));
    }

    public boolean isCollectionPainted(Color desiredColor, List<Block> collectionOfBlocks) {
        boolean allPainted = true;
        for (Block aBlock : collectionOfBlocks) {
            if (!(aBlock.getColor().equals(desiredColor)))
                allPainted = false;
        }
        return allPainted;
    }
}
