import java.util.List;

public class Accountant {

    public Accountant(){}

    public int calculateOrder(List<Blueprint> customerOrder) {
        int result = 0;
        for (Blueprint cost : customerOrder)
            result += calculateCost(cost);

        return result;
    }

    public int calculateCost(Blueprint order) {
        int result = 0;
        result += order.getShapePlanned().getPrice();
        if (order.getColorPlanned().equals(Color.RED))
            result++;

        result *= order.getQuantityOfBlock();
        return result;
    }
}