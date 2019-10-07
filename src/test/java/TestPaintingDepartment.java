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
    public void paintOneBlock() {
        Block testBlock = new Block(Shape.SQUARE);

        testPaint.paintBlock(testBlock);

        Assert.assertTrue(testBlock.getColor().equals(Color.RED));
    }
}
