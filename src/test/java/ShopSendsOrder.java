import io.ConsoleInput;
import io.ConsoleOutput;
import services.report.Invoice;
import services.factory.Block;
import services.factory.paint.Color;
import services.factory.cut.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.order.Blueprint;
import services.order.Customer;
import services.order.CustomerOrder;
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