import io.IInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Shop;
import services.ordering.Clerk;

public class ProgramReturns {
    private Clerk clerk;
    private Shop shop;
    private IInput input;
    private FakeOutput output;

    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;

    @Before
    public void init() {
        input = new StubInput(USERNAME, ORDER_QUANTITY);
        output = new FakeOutput();
        clerk = new Clerk(input, output);
        shop = new Shop(clerk);
    }

    @Test
    public void totalCostOfOrder() {
        shop.startTransaction();
        int oneOfEachBlock = 21;

        Assert.assertEquals(oneOfEachBlock, output.getOrderTotal());
    }
}