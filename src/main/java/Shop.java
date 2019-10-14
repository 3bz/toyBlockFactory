import java.util.List;

public class Shop {
    private ToyBlockFactory factory;
    private Accountant accountant;

    public Shop()
    {
        factory = new ToyBlockFactory();
        accountant = new Accountant();
    }

    public int receiveOrder(CustomerOrder customerOrder) {
        sendOrderToFactory(customerOrder);
        return processOrderCosts(customerOrder);
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return factory.processCustomerOrder(customerOrder);
    }

    private int processOrderCosts(CustomerOrder customerOrder) {
        return accountant.analyseOrderForCalculating(customerOrder);
    }
}