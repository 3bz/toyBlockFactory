package components;

import io.Input;
import io.Output;
import components.report.Accountant;
import components.report.Invoice;
import components.factory.Block;
import components.factory.ToyBlockFactory;
import components.order.Clerk;
import components.order.CustomerOrder;

import java.util.List;

public class Shop {
    private Clerk clerk;
    private ToyBlockFactory factory;
    private Accountant accountant;

    public Shop(Input input, Output output) {
        clerk = new Clerk(input, output);
        factory = new ToyBlockFactory();
        accountant = new Accountant();
    }

    public void startTransaction(){
        CustomerOrder designPatterns = clerk.getCustomerOrder();
        getBlocks(designPatterns);
        clerk.displayInvoice(getInvoice(designPatterns));
    }

    public List<Block> getBlocks(CustomerOrder customerOrder) {
        return factory.processOrder(customerOrder);
    }

    public Invoice getInvoice(CustomerOrder customerOrder) {
        return accountant.writeInvoice(customerOrder);
    }
}