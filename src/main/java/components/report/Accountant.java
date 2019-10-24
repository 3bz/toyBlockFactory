package components.report;

import components.factory.paint.Color;
import components.factory.cut.Shape;
import components.order.Blueprint;
import components.order.CustomerOrder;

import java.util.List;

public class Accountant {

    public Invoice writeInvoice(CustomerOrder orders) {
        Invoice invoice = new Invoice(orders);
        int cost;
        int quantity;

        for (Shape shape: Shape.values()) {
            quantity = howManyShapeOrders(shape, orders);
            cost = (shape.getPrice() * quantity);
            invoice.applyExpenses(quantity, cost, shape);
        }
        for (Color color: Color.values()) {
            if (color.getPrice() > 0)
                calculatePremiumPaintCharge(orders, invoice, color);
        }
        invoice.applyOrderTotal(getTotalCostOfOrders(orders.getBlueprints()));

        return invoice;
    }

    private int howManyShapeOrders(Shape shape, CustomerOrder order) {
        int shapeOrders = 0;

        for (Blueprint bp : order.getBlueprints()) {
            if (bp.getShapePlanned().equals(shape)) {
                shapeOrders += bp.getQuantityPlanned();
            }
        }
        return shapeOrders;
    }

    private void calculatePremiumPaintCharge(CustomerOrder orders, Invoice invoice, Color color) {
        int blockCount = howManySpecifiedColorBlocks(orders.getBlueprints(), color);
        int total = (blockCount * color.getPrice());
        invoice.applyPremiumPaintSurcharge(blockCount, total, color);

    }

    private int howManySpecifiedColorBlocks(List<Blueprint> orders, Color color) {
        int coloredBlockFound = 0;
        for (Blueprint bp : orders) {
            if (bp.getColorPlanned().equals(color)) {
                coloredBlockFound += bp.getQuantityPlanned();
            }
        }
        return coloredBlockFound;
    }

    private int getTotalCostOfOrders(List<Blueprint> orders) {
        int result = 0;
        for (Blueprint expense : orders)
            result += calculateSingleOrder(expense);

        return result;
    }

    private int calculateSingleOrder(Blueprint order) {
        int result = 0;
        result += order.getShapePlanned().getPrice();
        if (order.getColorPlanned().getPrice() > 0)
            result += order.getColorPlanned().getPrice();

        result *= order.getQuantityPlanned();
        return result;
    }
}