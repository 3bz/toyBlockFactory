import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPaintingDepartment {
    private PaintingDepartment testPaint;

    @Before
    public void init(){
        testPaint = new PaintingDepartment();
    }

    @Test
    public void paintBlockRed() {
        Block testBlock = new Block(Shape.SQUARE);

        testPaint.paintBlock(testBlock, Color.RED);

        Assert.assertTrue(testBlock.getColor().equals(Color.RED));
    }

    @Test
    public void paintBlockBlue() {
        Block testBlock = new Block(Shape.SQUARE);

        testPaint.paintBlock(testBlock, Color.BLUE);

        Assert.assertTrue(testBlock.getColor().equals(Color.BLUE));
    }

    @Test
    public void paintBlockYellow() {
        Block testBlock = new Block(Shape.SQUARE);

        testPaint.paintBlock(testBlock, Color.YELLOW);

        Assert.assertTrue(testBlock.getColor().equals(Color.YELLOW));
    }
}
