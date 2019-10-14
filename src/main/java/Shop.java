import java.util.List;

public class Shop {
    private IOutput output;
    private ToyBlockFactory factory;

    public Shop(IOutput aOutput)
    {
        output = aOutput;
        factory = new ToyBlockFactory();
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return factory.processCustomerOrder(customerOrder);
    }
}
