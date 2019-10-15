import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clerk {
    private final IInput input;
    private final IOutput output;

    private final Shop shop;
    private int currentOrderNo;
    private Date currentDate;
    private Customer customerServing;

    public Clerk(IInput aInput, IOutput aOutput) {
        input = aInput;
        output = aOutput;

        shop = new Shop();
        currentOrderNo = 0000;
        currentDate = Date.from(Instant.now());
    }

    public Invoice startTransaction() {
        customerServing = greetCustomer();
        List<Blueprint> designOrder = drawBlueprints();
        CustomerOrder customerOrder = createCustomerOrder(designOrder);
        Invoice customerInvoice = sendOrderToShop(customerOrder);
        output.giveOutput(customerInvoice.getMessage());
        return customerInvoice;
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
        return new CustomerOrder(customerServing, currentDate, currentOrderNo, customerRequests);          //change date
    }

    private Invoice sendOrderToShop(CustomerOrder customerOrder) {
        return shop.receiveOrder(customerOrder);
    }
}
