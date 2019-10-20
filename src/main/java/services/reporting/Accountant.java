package services.reporting;

import services.factory.painting.Color;
import services.factory.shaping.Shape;
import services.ordering.Blueprint;
import services.ordering.CustomerOrder;

import java.util.List;

public class Accountant {

    public Accountant() {}

    public Invoice analyseOrderForCalculating(CustomerOrder customerOrder) {
        return writeInvoice(customerOrder);
    }

    private Invoice writeInvoice(CustomerOrder orders) {
        Invoice invoice = new Invoice(orders);
        int cost;
        int quantity;

        for (Shape shape: Shape.values()) {
            quantity = findShapeOrders(shape, orders);
            cost = (shape.getPrice() * quantity);
            invoice.applyExpenses(quantity, cost, shape);
        }
        for (Color color: Color.values()) {
            if (color.getPrice() > 0)
                calculatePremiumPaintConsiderations(orders, invoice, color);
        }
        invoice.applyOrderTotal(calculateOrder(orders.getSpecification()));

        return invoice;
    }

    private int findShapeOrders(Shape shape, CustomerOrder order) {
        int shapeOrders = 0;

        for (Blueprint bp : order.getSpecification()) {
            if (bp.getShapePlanned().equals(shape)) {
                shapeOrders += bp.getQuantity();
            }
        }
        return shapeOrders;
    }

    private void calculatePremiumPaintConsiderations(CustomerOrder orders, Invoice invoice, Color color) {
        int blockCount = findSpecifiedColorBlocks(orders.getSpecification(), color);
        int total = (blockCount * color.getPrice());
        invoice.applyPremiumPaintSurcharge(blockCount, total, color);

    }

    private int findSpecifiedColorBlocks(List<Blueprint> orders, Color color) {
        int coloredBlockFound = 0;
        for (Blueprint bp : orders) {
            if (bp.getColorPlanned().equals(color)) {
                coloredBlockFound += bp.getQuantity();
            }
        }
        return coloredBlockFound;
    }

    public int calculateOrder(List<Blueprint> expenses) {
        int result = 0;
        for (Blueprint cost : expenses)
            result += calculateCost(cost);

        return result;
    }

    public int calculateCost(Blueprint order) {
        int result = 0;
        result += order.getShapePlanned().getPrice();
        if (order.getColorPlanned().getPrice() > 0)
            result += order.getColorPlanned().getPrice();

        result *= order.getQuantity();
        return result;
    }
}