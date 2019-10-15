public class ConsoleOutput implements IOutput {

    public void giveString(String s) {
        System.out.println(s);
    }

    @Override
    public void giveOutput(Invoice i) {
        System.out.println(i.getMessage());
    }

    @Override
    public void generateItemOption(String color, String shape) {
        System.out.println("Please input the number of " + color + " " + shape + "s: ");
    }
}