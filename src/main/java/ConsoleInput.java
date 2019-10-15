import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scn;

    public ConsoleInput() {
        scn = new Scanner(System.in);
    }

    @Override
    public int takeInteger() {
        int result;
        try {
            result = scn.nextInt();
            return result;
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input");
            scn.nextLine();
        }
        return takeInteger();
    }

    @Override
    public String takeString() {
        return scn.nextLine();
    }
}