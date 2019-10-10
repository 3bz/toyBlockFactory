import java.util.List;

public class Shop {
    private ToyBlockFactory factory;

    public Shop() {
        factory = new ToyBlockFactory();
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return factory.processCustomerOrder(customerOrder);
    }
}
