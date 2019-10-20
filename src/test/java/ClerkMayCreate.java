import io.ConsoleOutput;
import io.IOutput;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.*;

import java.util.List;

public class ClerkMayCreate {
    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;
    private final int ONE_OF_EACH_OPTION = 9;

    private Clerk clerk;

    @Before
    public void init() {
        StubInput input = new StubInput(USERNAME, ORDER_QUANTITY);
        IOutput output = new ConsoleOutput();
        clerk = new Clerk(input, output);
    }

    @Test
    public void aNewCustomer() {
        CustomerOrder testOrder = clerk.getCustomerOrder();

        Assert.assertEquals(USERNAME, testOrder.getCustomerDetails().getName());
    }

    @Test
    public void someBlueprints() {
        List<Blueprint> testPrints = clerk.getCustomerOrder().getSpecification();

        Assert.assertEquals(ONE_OF_EACH_OPTION, testPrints.size());
    }

    @Test
    public void anOrder() {
        CustomerOrder testOrder = clerk.getCustomerOrder();

        Assert.assertEquals(ONE_OF_EACH_OPTION, testOrder.getSpecification().size());
    }
}