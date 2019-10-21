package services;

import io.IInput;
import io.IOutput;
import services.reporting.Accountant;
import services.reporting.Invoice;
import services.factory.Block;
import services.factory.ToyBlockFactory;
import services.ordering.Clerk;
import services.ordering.CustomerOrder;

import java.util.List;

public class Shop {
    private Clerk clerk;
    private ToyBlockFactory factory;
    private Accountant accountant;

    public Shop(IInput input, IOutput output) {
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