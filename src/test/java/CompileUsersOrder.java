import io.Output;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import components.order.*;

import java.util.List;

public class CompileUsersOrder {
    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;
    private final int ONE_OF_EACH_OPTION = 9;

    private Clerk clerk;

    @Before
    public void init() {
        StubInput input = new StubInput(USERNAME, ORDER_QUANTITY);
        Output output = new FakeOutput();
        clerk = new Clerk(input, output);
    }

    @Test
    public void aNewCustomer() {
        CustomerOrder testOrder = clerk.takeCustomerOrder();

        Assert.assertEquals(USERNAME, testOrder.getCustomerDetails().getName());
    }

    @Test
    public void blockRequests() {
        List<Blueprint> testPrints = clerk.takeCustomerOrder().getBlueprints();

        Assert.assertEquals(ONE_OF_EACH_OPTION, testPrints.size());
    }

    @Test
    public void anOrder() {
        CustomerOrder testOrder = clerk.takeCustomerOrder();

        Assert.assertEquals(ONE_OF_EACH_OPTION, testOrder.getBlueprints().size());
    }
}