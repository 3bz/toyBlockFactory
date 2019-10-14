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
}