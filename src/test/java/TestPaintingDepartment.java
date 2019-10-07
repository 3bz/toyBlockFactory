import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPaintingDepartment {
    private PaintingDepartment testPaint;
    private List<Block> testBlocks;

    @Before
    public void init(){
        testPaint = new PaintingDepartment();
        testBlocks = new ArrayList<>();
        testBlocks.add(new Block(Shape.SQUARE));
    }

    @Test
    public void paintSingleBlock() {
        testPaint.paintBlock(testBlocks, Color.RED);

        Assert.assertEquals(testBlocks.get(0).getColor(), Color.RED);
    }

    @Test
    public void paintManyBlocks() {
        for (int i = 0; i < 5; i++)
            testBlocks.add(new Block(Shape.SQUARE));

        testPaint.paintBlock(testBlocks, Color.BLUE);

        for (int j = 0; j < testBlocks.size(); j++)
            Assert.assertEquals(testBlocks.get(j).getColor(), Color.BLUE);
    }

    @Test
    public void paintDifferentShapesSameColor() {
        testBlocks.add(new Block(Shape.CIRCLE));
        testBlocks.add(new Block(Shape.TRIANGLE));

        testPaint.paintBlock(testBlocks, Color.YELLOW);

        for (int i = 0; i < testBlocks.size(); i++)
            Assert.assertEquals(testBlocks.get(i).getColor(), Color.YELLOW);
    }
}
