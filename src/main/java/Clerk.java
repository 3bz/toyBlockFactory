import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clerk {
    private IInput input;
    private IOutput output;

    private Shop shop;
    private int currentOrderNo;
    private Date currentDate;
    private Customer customerServing;

    public Clerk(IInput aInput, IOutput aOutput) {
        input = aInput;
        output = aOutput;

        shop = new Shop();
        currentOrderNo = 0;
        currentDate = Date.from(Instant.now());
    }

    public int doTransaction(){
        customerServing = greetCustomer();
        List<Blueprint> designOrder = drawBlueprints();
        CustomerOrder customerOrder = createCustomerOrder(designOrder);
        List<Block> blocksMadeToOrder = sendOrderToFactory(customerOrder);
        return sendOrderToShop(customerOrder);
    }

    public Customer greetCustomer() {
        output.giveOutput(Constants.WELCOME_MESSAGE);
        output.giveOutput(Constants.NAME_REQUEST);
        String customerName = input.takeString();
        output.giveOutput(Constants.ADDRESS_REQUEST);
        String customerAddress = input.takeString();

        return createNewCustomer(customerName, customerAddress);
    }

    private Customer createNewCustomer(String name, String address) {
        return new Customer(name, address);
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return shop.sendOrderToFactory(customerOrder);
    }

    public int sendOrderToShop(CustomerOrder customerOrder) {
        return shop.processOrderCosts(customerOrder);
    }

    public List<Blueprint> drawBlueprints() {
        int quantity;
        List<Blueprint> totalOrder = new ArrayList<>();
        for (Shape aShape : Shape.values()) {
            for (Color aColor : Color.values()) {
                output.giveOutput(aColor.name() + " " + aShape.name() + ": ");
                quantity = input.takeInteger();
                if(quantity > 0)
                    totalOrder.add(new Blueprint(aColor, aShape, quantity));
            }
        }
        return totalOrder;
    }

    public CustomerOrder createCustomerOrder(List<Blueprint> customerRequests) {
        currentOrderNo++;
        return new CustomerOrder(customerServing, currentDate, currentOrderNo, customerRequests); //change date
    }
}
