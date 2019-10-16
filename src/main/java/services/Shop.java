package services;

import services.datareturn.Accountant;
import services.datareturn.Invoice;
import services.factory.Block;
import services.factory.ToyBlockFactory;
import services.userdata.CustomerOrder;

import java.util.List;

public class Shop {
    private ToyBlockFactory factory;
    private Accountant accountant;

    public Shop() {
        factory = new ToyBlockFactory();
        accountant = new Accountant();
    }

    public Invoice receiveOrder(CustomerOrder customerOrder) {
        sendOrderToFactory(customerOrder);
        return processOrderCosts(customerOrder);
    }

    public List<Block> sendOrderToFactory(CustomerOrder customerOrder) {
        return factory.processCustomerOrder(customerOrder);
    }

    private Invoice processOrderCosts(CustomerOrder customerOrder) {
        return accountant.analyseOrderForCalculating(customerOrder);
    }
}