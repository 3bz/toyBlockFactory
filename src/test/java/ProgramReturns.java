import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramReturns {
    private Clerk clerk;
    private IInput input;
    private FakeOutput output;


    @Before
    public void init() {
        input = new StubInput();
        output = new FakeOutput();
        clerk = new Clerk(input, output);
    }

    @Test
    public void totalCostOfOrder() {
        clerk.startTransaction();

        Assert.assertEquals(21, output.getOrderTotal());
    }
}