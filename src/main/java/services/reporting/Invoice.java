package services.reporting;

import services.factory.painting.Color;
import services.factory.cutting.Shape;
import services.ordering.CustomerOrder;

import java.util.Date;

public class Invoice {
    private String message;
    private String name;
    private String address;
    private Date dueDate;
    private int orderNo;
    private int total;

    public Invoice(CustomerOrder customerOrder) {
        name = customerOrder.getCustomerDetails().getName();
        address = customerOrder.getCustomerDetails().getAddress();
        dueDate = customerOrder.getDueDate();
        orderNo = customerOrder.getOrderNo();

        message = "Your invoice report has been generated:\n\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Due Date: " + dueDate + "\n" +
                "Order #: " + orderNo + "\n\n";
    }

    public void applyExpenses(int quantity, int total, Shape shape) {
        message+= shape.name() + ": " + quantity + " @ " + "$" + shape.getPrice() + " ppi = $" + total + "\n";
    }

    public void applyPremiumPaintSurcharge(int quantity, int total, Color color) {
        message+= color.name() + " Color Surcharge: " + quantity + " @ " + "$" + color.getPrice() + " ppi = $" + total + "\n";
    }

    public void applyOrderTotal(int total) {
        this.total = total;
        message += "Order Total: $" + total + "\n";
    }

    public int getTotal() {
        return total;
    }

    public String getMessage() {
        return message;
    }
}
