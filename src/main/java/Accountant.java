public class Accountant {

    public Accountant(){

    }

    public int calculateCost(Blueprint order) {
        int result = 0;
        result += order.getShapePlanned().getPrice();
        if (order.getColorPlanned().equals(Color.RED))
            result++;
        return result;
    }
}
