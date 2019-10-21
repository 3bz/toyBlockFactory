import io.IInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Shop;

public class ProgramReturns {
    private IInput input;
    private FakeOutput output;
    private Shop shop;

    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;

    @Before
    public void init() {
        input = new StubInput(USERNAME, ORDER_QUANTITY);
        output = new FakeOutput();
        shop = new Shop(input, output);
    }

    @Test
    public void totalCostOfOrder() {
        shop.startTransaction();
        int oneOfEachBlock = 21;

        Assert.assertEquals(oneOfEachBlock, output.getOrderTotal());
    }
}