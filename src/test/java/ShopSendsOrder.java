import io.ConsoleInput;
import io.ConsoleOutput;
import services.ordering.Clerk;
import services.reporting.Invoice;
import services.factory.Block;
import services.factory.painting.Color;
import services.factory.shaping.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.Blueprint;
import services.ordering.Customer;
import services.ordering.CustomerOrder;
import services.Shop;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ShopSendsOrder {
    private Shop shop;
    private CustomerOrder customerOrder;

    @Before
    public void init() {
        Clerk clerk = new Clerk(new ConsoleInput(), new ConsoleOutput());
        shop = new Shop(clerk);

        Blueprint testDesign = new Blueprint(Color.RED, Shape.SQUARE, 3);
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(testDesign);

        customerOrder = new CustomerOrder(new Customer("test", "test"),
                Date.from(Instant.now()), 1, testSpec);
    }

    @Test
    public void toFactory_ReceivesBlocks() {
        List<Block> blockShipment = shop.getBlocks(customerOrder);

        Assert.assertEquals(3, blockShipment.size());
    }

    @Test
    public void toAccountant_ReceivesInvoice() {
        Invoice testInvoice = shop.getInvoice(customerOrder);
        int invoiceTotal = testInvoice.getTotal();


        Assert.assertEquals(6, invoiceTotal);
    }
}