import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TestClerk {
    private Clerk clerk;
    private CustomerOrder customerOrder;

    @Before
    public void init() {
    clerk = new Clerk();
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 3));
        customerOrder = new CustomerOrder(new Customer("test", "test"),
                Date.from(Instant.now()), 1, testSpec);
    }

    @Test
    public void sendsCustomerOrderToShop_ReceivesBlocks() {
        List<Block> blockShipment = clerk.sendOrderToFactory(customerOrder);

        Assert.assertEquals(3, blockShipment.size());
    }

    @Test
    public void createsCustomer() {
        Customer testCustomer = clerk.createNewCustomer("Joe", "TestAddress");

        Assert.assertEquals("Joe", testCustomer.getName());
        Assert.assertEquals("TestAddress", testCustomer.getAddress());
    }

    @Test
    public void createsOrder() {
        CustomerOrder testOrder = clerk.createCustomerOrder();

        Assert.assertEquals(1, testOrder.getSpecification().size());
    }
}
