import java.util.List;

public class Shop {
    private ToyBlockFactory factory;
    private Accountant accountant;

    public Shop()
    {
        factory = new ToyBlockFactory();
        accountant = new Accountant();
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return factory.processCustomerOrder(customerOrder);
    }

    public int processOrderCosts(CustomerOrder customerOrder) {
        return accountant.calculateOrder(customerOrder.getSpecification());
    }
}
