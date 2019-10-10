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
}
