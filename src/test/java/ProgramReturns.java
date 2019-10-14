import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Acceptance {
    private Clerk clerk;
    private IInput input;
    private IOutput output;


    @Before
    public void init() {
        input = new StubInput();
        output = new ConsoleOutput();
        clerk = new Clerk(input, output);
    }

    @Test
    public void programReturnsTotalCostOfOrder() {
        int actual = clerk.doTransaction();

        Assert.assertEquals(21, actual);
    }
}