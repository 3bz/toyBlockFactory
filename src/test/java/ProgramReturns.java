import io.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import components.Shop;

public class ProgramReturns {
    private FakeOutput output;
    private Shop shop;

    private final String USERNAME = "test";
    private final int ORDER_QUANTITY = 1;

    @Before
    public void init() {
        Input input = new StubInput(USERNAME, ORDER_QUANTITY);
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