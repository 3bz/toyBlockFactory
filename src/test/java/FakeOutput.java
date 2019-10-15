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

    public int getOrderTotal() {
        return orderTotal;
    }
}
