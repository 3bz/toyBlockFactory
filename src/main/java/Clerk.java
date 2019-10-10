import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clerk {
    private Shop shop;
    private int currentOrderNo;
    private Date currentDate;
    private Customer customerServing;

    public Clerk() {
        init();
        CustomerOrder customerOrder = createCustomerOrder();
    }

    public void init(){
        shop = new Shop();
        currentOrderNo = 0;
        currentDate = Date.from(Instant.now());
        greetCustomer();
    }

    public void greetCustomer() {
        //some output
        //require input, set input variables
        customerServing = createNewCustomer("input", "123");
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return shop.sendOrderToFactory(customerOrder);
    }

    public Customer createNewCustomer(String name, String address) {
        return new Customer(name, address);
    }

    public CustomerOrder createCustomerOrder() {
        List<Blueprint> customerRequests = new ArrayList<>();
        customerRequests.add(new Blueprint(Color.RED, Shape.SQUARE, 1));
        currentOrderNo++;
        return new CustomerOrder(customerServing, currentDate, currentOrderNo, customerRequests);
    }
}
