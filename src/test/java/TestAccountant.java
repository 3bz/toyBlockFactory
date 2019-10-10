import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAccountant {
    private Accountant acc;

    @Before
    public void init() {
        acc = new Accountant();
    }

    @Test
    public void calculateSquareCost() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.SQUARE, 1);

        int expectedCost = 1;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void calculateTriangleCost() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.TRIANGLE, 1);

        int expectedCost = 2;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void calculateCircleCost() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.CIRCLE, 1);

        int expectedCost = 3;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void redPaintSurcharge() {
        Blueprint testPrint = new Blueprint(Color.RED, Shape.SQUARE, 1);

        int expectedCost = 2;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }
}
