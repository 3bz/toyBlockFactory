
import services.ordering.Customer;
import services.ordering.CustomerOrder;
import services.reporting.Accountant;
import services.factory.painting.Color;
import services.factory.cutting.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.Blueprint;
import services.reporting.Invoice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountantCanCalculate {
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
    public void squareCost() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.SQUARE, 1));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 1;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void triangleCost() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 1));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 2;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void circleCost() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 1));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 3;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void redPaintSurcharge() {
        customerOrder.getSpecification().add(new Blueprint(Color.RED, Shape.SQUARE, 1));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 2;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void multipleOfTheSameBlock() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 5;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void eachShapeInSingleOrder() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.SQUARE, 1));
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 1));
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 1));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 6;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedBlockOrder() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.TRIANGLE, 5));
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 30;

        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void assortedOrderWithRedBlocks() {
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.SQUARE, 5));
        customerOrder.getSpecification().add(new Blueprint(Color.RED, Shape.SQUARE, 5));
        customerOrder.getSpecification().add(new Blueprint(Color.BLUE, Shape.CIRCLE, 5));

        Invoice invoice = acc.analyseOrderForCalculating(customerOrder);
        int actualCost = invoice.getTotal();
        int expectedCost = 30;

        Assert.assertEquals(expectedCost, actualCost);
    }
}