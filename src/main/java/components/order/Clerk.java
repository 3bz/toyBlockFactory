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

    public Clerk(Input aInput, Output aOutput) {
        input = aInput;
        output = aOutput;
        currentOrderNo = 0;
    }

    public CustomerOrder getCustomerOrder() {
        Customer newCustomer = getCustomerDetails();
        List<Blueprint> blockDesigns = drawBlueprints();
        return createCustomerOrder(newCustomer, blockDesigns);
    }

    public void displayInvoice(Invoice aInvoice) {
        output.giveOutput(aInvoice);
    }

    private Customer getCustomerDetails() {
        output.giveString(Constants.WELCOME_MESSAGE);
        output.giveString(Constants.NAME_REQUEST);
        String customerName = input.takeString();
        output.giveString(Constants.ADDRESS_REQUEST);
        String customerAddress = input.takeString();

        return new Customer(customerName, customerAddress);
    }

    private List<Blueprint> drawBlueprints() {
        int quantity;
        List<Blueprint> totalOrder = new ArrayList<>();
        for (Shape aShape : Shape.values()) {
            for (Color aColor : Color.values()) {
                output.generateItemOption(aColor.name().toLowerCase(), aShape.name().toLowerCase());
                quantity = input.takeInteger();
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
