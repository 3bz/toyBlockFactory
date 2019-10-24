package components.order;

import java.util.Date;
import java.util.List;

public class CustomerOrder {
    private Customer customerDetails;
    private Date dueDate;
    private int orderNo;
    private List<Blueprint> blueprints;

    public CustomerOrder(Customer aCustomer, Date aDueDate, int aOrderNo, List<Blueprint> aBlueprints) {
        customerDetails = aCustomer;
        dueDate = aDueDate;
        orderNo = aOrderNo;
        blueprints = aBlueprints;
    }

    public List<Blueprint> getBlueprints() {
        return blueprints;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getOrderNo() {
        return orderNo;
    }
}