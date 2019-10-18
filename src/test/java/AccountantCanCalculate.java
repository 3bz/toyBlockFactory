import services.reporting.Accountant;
import services.factory.painting.Color;
import services.factory.shaping.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.Blueprint;

import java.util.ArrayList;
import java.util.List;

public class AccountantCanCalculate {
    private Accountant acc;
    private List<Blueprint> customerOrder;

    @Before
    public void init() {
        acc = new Accountant();
        customerOrder = new ArrayList<>();
    }

    @Test
    public void squareCost() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.SQUARE, 1);

        int expectedCost = 1;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void triangleCost() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.TRIANGLE, 1);

        int expectedCost = 2;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void circleCost() {
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

    @Test
    public void eachShapeInSingleOrder() {
        customerOrder.add(new Blueprint(Color.BLUE, Shape.SQUARE, 1));
        customerOrder.add(new Blueprint(Color.BLUE, Shape.CIRCLE, 1));
        customerOrder.add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 1));

        int expectedCost = 6;
        int actualCost = acc.calculateOrder(customerOrder);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void multipleOfTheSameBlock() {
        Blueprint testPrint = new Blueprint(Color.BLUE, Shape.SQUARE, 5);

        int expectedCost = 5;
        int actualCost = acc.calculateCost(testPrint);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedBlockOrder() {
        customerOrder.add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 5));
        customerOrder.add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        int expectedCost = 30;
        int actualCost = acc.calculateOrder(customerOrder);

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedOrderWithRedBlocks() {
        customerOrder.add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.add(new Blueprint(Color.RED, Shape.SQUARE, 5));
        customerOrder.add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        int expectedCost = 30;
        int actualCost = acc.calculateOrder(customerOrder);

        Assert.assertEquals(expectedCost, actualCost);
    }
}