import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scn;

    public ConsoleInput() {
        scn = new Scanner(System.in);
    }

    @Override
    public int takeInput() {
        return scn.nextInt();
    }
}
