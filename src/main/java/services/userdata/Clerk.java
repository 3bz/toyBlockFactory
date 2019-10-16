package services.userdata;

import io.IInput;
import io.IOutput;
import services.Shop;
import services.datareturn.Invoice;
import services.factory.model.Color;
import services.factory.model.Shape;

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
        currentOrderNo = 0;
        currentDate = Date.from(Instant.now());
    }

    public void startTransaction(){
        customerServing = greetCustomer();
        List<Blueprint> designOrder = drawBlueprints();
        CustomerOrder customerOrder = createCustomerOrder(designOrder);
        Invoice customerInvoice = sendOrderToShop(customerOrder);
        output.giveOutput(customerInvoice);
    }

    public Customer greetCustomer() {
        output.giveString(Constants.WELCOME_MESSAGE);
        output.giveString(Constants.NAME_REQUEST);
        String customerName = input.takeString();
        output.giveString(Constants.ADDRESS_REQUEST);
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
                output.generateItemOption(aColor.name().toLowerCase(), aShape.name().toLowerCase());
                quantity = input.takeInteger();
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

    private Invoice sendOrderToShop(CustomerOrder customerOrder) {
        return shop.receiveOrder(customerOrder);
    }
}