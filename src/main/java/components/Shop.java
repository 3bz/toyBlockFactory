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
        CustomerOrder blockOrder = clerk.takeCustomerOrder();
        createBlocks(blockOrder);
        clerk.displayInvoice(getInvoice(blockOrder));
    }

    private List<Block> createBlocks(CustomerOrder customerOrder) {
        return factory.processBlockOrder(customerOrder);
    }

    private Invoice getInvoice(CustomerOrder customerOrder) {
        return accountant.writeInvoice(customerOrder);
    }
}