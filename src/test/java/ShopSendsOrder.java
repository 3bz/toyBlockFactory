import services.datareturn.Invoice;
import services.factory.Block;
import services.factory.model.Color;
import services.factory.model.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Shop;
import services.userdata.Blueprint;
import services.userdata.Customer;
import services.userdata.CustomerOrder;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ShopSendsOrder {
    private Shop shop;
    private CustomerOrder customerOrder;

    @Before
    public void init() {
        shop = new Shop();
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 3));
        customerOrder = new CustomerOrder(new Customer("test", "test"),
                Date.from(Instant.now()), 1, testSpec);
    }

    @Test
    public void toFactory_ReceivesBlocks() {
        List<Block> blockShipment = shop.sendOrderToFactory(customerOrder);

        Assert.assertEquals(3, blockShipment.size());
    }

    @Test
    public void toAccountant_ReceivesTotalCost() {
        Invoice testInvoice = shop.receiveOrder(customerOrder);
        int actual = testInvoice.getTotal();


        Assert.assertEquals(6, actual);
    }
}