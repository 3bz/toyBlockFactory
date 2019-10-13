import java.util.ArrayList;
import java.util.List;

public class Accountant {

    public Accountant(){}

    public void analyseOrderForCalculating(CustomerOrder customerOrder) {
        List<Blueprint> expenses = new ArrayList<>();
        for (Blueprint itemOrder : customerOrder.getSpecification())
            expenses.add(itemOrder);
        int totalCost = calculateOrder(expenses);
        //processInvoice(customerOrder);
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