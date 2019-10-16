package services.userdata;

import java.util.Date;
import java.util.List;

public class CustomerOrder {
    private Customer customerDetails;
    private Date dueDate;
    private int orderNo;
    private List<Blueprint> specification;

    public CustomerOrder(Customer aCustomer, Date aDueDate, int aOrderNo, List<Blueprint> aSpecification) {
        customerDetails = aCustomer;
        dueDate = aDueDate;
        orderNo = aOrderNo;
        specification = aSpecification;
    }

    public List<Blueprint> getSpecification() {
        return specification;
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