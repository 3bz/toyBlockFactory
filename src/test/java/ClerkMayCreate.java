import io.ConsoleOutput;
import io.IOutput;
import services.factory.painting.Color;
import services.factory.shaping.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ordering.*;

import java.util.ArrayList;
import java.util.List;

public class ClerkMayCreate {
    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;

    private Clerk clerk;
    private List<Blueprint> testSpec;

    @Before
    public void init() {
        StubInput input = new StubInput(USERNAME, ORDER_QUANTITY);
        IOutput output = new ConsoleOutput();
        clerk = new Clerk(input, output);
        testSpec = new ArrayList<>();
        testSpec.add(new Blueprint(Color.RED, Shape.SQUARE, 1));
    }

    @Test
    public void aNewCustomer() {
        CustomerOrder testOrder = clerk.getCustomerOrder();

        Assert.assertEquals(USERNAME, testOrder.getCustomerDetails().getName());
    }

    @Test
    public void anOrder() {
        CustomerOrder testOrder = clerk.getCustomerOrder();

        Assert.assertEquals(9, testOrder.getSpecification().size());
    }

    @Test
    public void someBlueprints() {
        List<Blueprint> testPrints = clerk.drawBlueprints();

        Assert.assertEquals(9, testPrints.size());
    }
}