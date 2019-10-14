import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scn;

    public ConsoleInput() {
        scn = new Scanner(System.in);
    }

    @Override
    public int takeInteger() {
        return scn.nextInt();
    }

    @Override
    public String takeString() { return scn.nextLine(); }
}