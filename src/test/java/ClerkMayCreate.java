import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClerkMayCreate {
    private Clerk clerk;
    private List<Blueprint> testSpec;

    @Before
    public void init() {
        IInput input = new StubInput();
        IOutput output = new ConsoleOutput();
        clerk = new Clerk(input, output);
        testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 1));
    }

    @Test
    public void aNewCustomer() {
        Customer testCustomer = clerk.greetCustomer();

        Assert.assertEquals("test", testCustomer.getName());
        Assert.assertEquals("test", testCustomer.getAddress());
    }

    @Test
    public void anOrder() {
        List<Blueprint> testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 1));
        CustomerOrder testOrder = clerk.createCustomerOrder(testSpec);

        Assert.assertEquals(1, testOrder.getSpecification().size());
    }

    @Test
    public void someBlueprints() {
        List<Blueprint> testPrints = clerk.drawBlueprints();

        Assert.assertEquals(9, testPrints.size());
    }
}