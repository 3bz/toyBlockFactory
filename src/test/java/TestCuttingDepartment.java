import org.junit.Assert;
import org.junit.Test;

public class TestCuttingDepartment {

    @Test
    public void cutsSquareBlock(){
        CuttingDepartment testCut = new CuttingDepartment();
        Block testBlock = testCut.cutShape(Shape.SQUARE);

        Assert.assertTrue(testBlock.getShape().equals(Shape.SQUARE));
    }

    @Test
    public void cutsCircleBlock(){
        CuttingDepartment testCut = new CuttingDepartment();
        Block testBlock = testCut.cutShape(Shape.CIRCLE);

        Assert.assertTrue(testBlock.getShape().equals(Shape.CIRCLE));
    }

    @Test
    public void cutsTriangleBlock(){
        CuttingDepartment testCut = new CuttingDepartment();
        Block testBlock = testCut.cutShape(Shape.TRIANGLE);

        Assert.assertTrue(testBlock.getShape().equals(Shape.TRIANGLE));
    }
}
