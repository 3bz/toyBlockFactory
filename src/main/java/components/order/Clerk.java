package components.order;

import io.Input;
import io.Output;
import components.report.Invoice;
import components.factory.paint.Color;
import components.factory.cut.Shape;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clerk {
    private final Input input;
    private final Output output;
    private int currentOrderNo;
    static final String WELCOME_MESSAGE = "Welcome to the Toy Block Factory!";
    static final String NAME_REQUEST = "Please input your name: ";
    static final String ADDRESS_REQUEST = "Please input your address: ";

    public Clerk(Input aInput, Output aOutput) {
        input = aInput;
        output = aOutput;
        currentOrderNo = 0;
    }

    public CustomerOrder takeCustomerOrder() {
        Customer newCustomer = getCustomerDetails();
        List<Blueprint> designPatterns = drawBlueprints();
        return createCustomerOrder(newCustomer, designPatterns);
    }

    public void displayInvoice(Invoice aInvoice) {
        output.giveOutput(aInvoice);
    }

    private Customer getCustomerDetails() {
        output.giveString(WELCOME_MESSAGE);
        output.giveString(NAME_REQUEST);
        String customerName = input.takeUserDetails();
        output.giveString(ADDRESS_REQUEST);
        String customerAddress = input.takeUserDetails();

        return new Customer(customerName, customerAddress);
    }

    private List<Blueprint> drawBlueprints() {
        int quantity;
        List<Blueprint> totalOrder = new ArrayList<>();
        for (Shape aShape : Shape.values()) {
            for (Color aColor : Color.values()) {
                output.generateItemOption(aColor.name().toLowerCase(), aShape.name().toLowerCase());
                quantity = input.takeOrderQuantity();
                if(quantity > 0)
                    totalOrder.add(new Blueprint(aColor, aShape, quantity));
            }
        }
        return totalOrder;
    }

    private CustomerOrder createCustomerOrder(Customer aCustomer, List<Blueprint> designs) {
        Date currentDate = Date.from(Instant.now());
        currentOrderNo++;
        return new CustomerOrder(aCustomer, currentDate, currentOrderNo, designs);
    }
}