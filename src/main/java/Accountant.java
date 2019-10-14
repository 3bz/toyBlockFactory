import java.util.List;

public class Accountant {

    public Accountant(){}

    public int analyseOrderForCalculating(CustomerOrder customerOrder) {
        return calculateOrder(customerOrder.getSpecification());
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
        if (order.getColorPlanned().equals(Color.RED))
            result+= Color.RED.getPrice();

        result *= order.getQuantityOfBlock();
        return result;
    }

    public int[] findShapeOrders(Shape shape, CustomerOrder order) {
        int[] shapeOrders = new int[Color.values().length];

        for(Blueprint bp : order.getSpecification()) {
            if(bp.getShapePlanned().equals(shape)) {
                for(int i = 0; i < Color.values().length; i++) {
                    if (bp.getColorPlanned().equals(Color.values()[i]))
                        shapeOrders[i] = bp.getQuantityOfBlock();
                }
            }
        }
        return shapeOrders;
    }

//    public static String fixedLengthString(String string, int length) {
//        return String.format("%-" + length + "s", string);
//    }
}