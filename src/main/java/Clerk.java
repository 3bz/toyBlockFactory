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

    public void run(){
        greetCustomer();
        List<Blueprint> designOrder = drawBlueprints(1);
        CustomerOrder customerOrder = createCustomerOrder(designOrder);
    }

    private void greetCustomer() {
        output.giveOutput(Constants.WELCOME_MESSAGE);
        //require input, set input variables
        customerServing = createNewCustomer("input", "123");
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return shop.sendOrderToFactory(customerOrder);
    }

    public Customer createNewCustomer(String name, String address) {
        return new Customer(name, address);
    }

    public List<Blueprint> drawBlueprints(int quantity) {
        //int quantity = 0;
        List<Blueprint> totalOrder = new ArrayList<>();
        for (Shape aShape : Shape.values()) {
            for (Color aColor : Color.values()) {
                System.out.println(aColor.name() + " " + aShape.name() + ": ");
                //quantity = scn.nextInt();
                if(quantity > 0)
                    totalOrder.add(new Blueprint(aColor, aShape, quantity));
            }
        }
        return totalOrder;
    }

    public CustomerOrder createCustomerOrder(List<Blueprint> customerRequests) {
        currentOrderNo++;
        return new CustomerOrder(customerServing, currentDate, currentOrderNo, customerRequests);
    }
}
