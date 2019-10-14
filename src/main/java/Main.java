public class Main {

    public static void main(String[] args) {
        IInput input = new ConsoleInput();
        IOutput output = new ConsoleOutput();
        Clerk clerk = new Clerk(input, output);

        clerk.run();
    }
}
