import services.reporting.Invoice;
import io.IOutput;

public class FakeOutput implements IOutput {
    private int orderTotal;

    @Override
    public void giveString(String s) {
        System.out.println(s);
    }

    @Override
    public void giveOutput(Invoice i) {
        orderTotal = i.getTotal();
    }

    @Override
    public void generateItemOption(String color, String shape) {
    }

    public int getOrderTotal() {
        return orderTotal;
    }
}
