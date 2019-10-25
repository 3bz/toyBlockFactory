import components.factory.paint.PaintingDepartment;
import components.factory.Block;
import components.factory.paint.Color;
import components.factory.paint.PaintingOrder;
import components.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChangeBlockColor {
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
    public void becomesRedBlock() {
        testOrder = new PaintingOrder(Color.RED, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.RED, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void becomesBlueBlock() {
        testOrder = new PaintingOrder(Color.BLUE, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.BLUE, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void becomesYellowBlock() {
        testOrder = new PaintingOrder(Color.YELLOW, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertEquals(Color.YELLOW, testOrder.getBlocksToPaint().get(0).getColor());
    }

    @Test
    public void manyRedBlocks() {
        for (int i = 0; i < 5; i++)
            blockList.add(new Block(Shape.SQUARE));

        testOrder = new PaintingOrder(Color.RED, blockList);
        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertTrue(isCollectionPainted(Color.RED, testOrder.getBlocksToPaint()));
    }

    @Test
    public void differentShapedBlocksAllSameColor() {
        blockList.add(new Block(Shape.CIRCLE));
        blockList.add(new Block(Shape.TRIANGLE));
        testOrder = new PaintingOrder(Color.RED, blockList);

        testPaintDept.fulfillPaintingOrder(testOrder);

        Assert.assertTrue(isCollectionPainted(Color.RED, testOrder.getBlocksToPaint()));
    }

    private boolean isCollectionPainted(Color desiredColor, List<Block> collectionOfBlocks) {
        boolean allPainted = true;
        for (Block aBlock : collectionOfBlocks) {
            if (!(aBlock.getColor().equals(desiredColor))) {
                allPainted = false;
                break;
            }
        }
        return allPainted;
    }
}