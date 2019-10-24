
import components.order.Customer;
import components.order.CustomerOrder;
import components.report.Accountant;
import components.factory.paint.Color;
import components.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import components.order.Blueprint;
import components.report.Invoice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostOfOrders {
    private Accountant acc;
    private CustomerOrder customerOrder;

    @Before
    public void init() {
        acc = new Accountant();

        Customer customer = new Customer("test", "test");
        List<Blueprint> designs = new ArrayList<>();
        customerOrder = new CustomerOrder(customer, Date.from(Instant.now()), 1, designs);
    }

    @Test
    public void oneSquareIsOneDollar() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.SQUARE, 1));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 1;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void oneTriangleIsTwoDollars() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 1));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 2;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void oneCircleIsThreeDollars() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 1));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 3;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void redPaintSurcharge() {
        customerOrder.getBlueprints().add(new Blueprint(Color.RED, Shape.SQUARE, 1));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 2;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void manyOfSameShape() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 5;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void oneOfEveryShape() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.SQUARE, 1));
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 1));
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 1));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 6;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedShapes() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 5));
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 30;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedShapesWithSomeThatAreRed() {
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.getBlueprints().add(new Blueprint(Color.RED, Shape.SQUARE, 5));
        customerOrder.getBlueprints().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        Invoice invoice = acc.writeInvoice(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 30;

        Assert.assertEquals(expectedCost, actualCost);
    }
}