import io.ConsoleInput;
import io.ConsoleOutput;
import components.report.Invoice;
import components.factory.Block;
import components.factory.paint.Color;
import components.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import components.order.Blueprint;
import components.order.Customer;
import components.order.CustomerOrder;
import components.Shop;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ShopSendsOrder {
    private Shop shop;
    private CustomerOrder customerOrder;

    @Before
    public void init() {
        shop = new Shop(new ConsoleInput(), new ConsoleOutput());

        Blueprint testDesign = new Blueprint(Color.RED, Shape.SQUARE, 3);
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(testDesign);
        Customer customer = new Customer("test", "test");

        customerOrder = new CustomerOrder(customer, Date.from(Instant.now()), 1, testSpec);
    }

    @Test
    public void toFactory_ReceivesBlocks() {
        List<Block> blockShipment = shop.getBlocks(customerOrder);

        Assert.assertEquals(3, blockShipment.size());
    }

    @Test
    public void toAccountant_ReceivesInvoice() {
        Invoice testInvoice = shop.getInvoice(customerOrder);
        int actualTotal = testInvoice.getTotal();


        Assert.assertEquals(6, actualTotal);
    }
}