import io.ConsoleInput;
import io.ConsoleOutput;
import services.ordering.Clerk;
import services.reporting.Invoice;
import services.factory.Block;
import services.factory.painting.Color;
import services.factory.cutting.Shape;
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