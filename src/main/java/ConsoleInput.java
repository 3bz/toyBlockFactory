import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scn;

    public ConsoleInput() {
        scn = new Scanner(System.in);
    }

    @Override
    public String takeInput() {
        return scn.nextLine();
    }
}
