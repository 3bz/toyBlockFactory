import services.factory.painting.PaintingDepartment;
import services.factory.Block;
import services.factory.painting.Color;
import services.factory.painting.PaintingOrder;
import services.factory.shaping.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PaintingDepartmentPaints {
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
    public void aRedBlock() {
        testOrder = new PaintingOrder(Color.RED, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void aBlueBlock() {
        testOrder = new PaintingOrder(Color.BLUE, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.BLUE, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void aYellowBlock() {
        testOrder = new PaintingOrder(Color.YELLOW, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.YELLOW, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void manyBlocks() {
        for (int i = 0; i < 5; i++)
            blockList.add(new Block(Shape.SQUARE));

        testOrder = new PaintingOrder(Color.RED, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertTrue(isCollectionPainted(Color.RED, testOrder.getBlocksToPaint()));
    }

    @Test
    public void differentShapesSameColor() {
        blockList.add(new Block(Shape.CIRCLE));
        blockList.add(new Block(Shape.TRIANGLE));
        testOrder = new PaintingOrder(Color.RED, blockList);

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