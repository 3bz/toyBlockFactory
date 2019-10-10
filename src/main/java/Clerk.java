import java.util.List;

public class Clerk {
    private Shop shop;

    public Clerk() {
        shop = new Shop();
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return shop.sendOrderToFactory(customerOrder);
    }
}
