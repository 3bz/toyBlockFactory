public class ConsoleOutput implements IOutput {

    @Override
    public void giveOutput(String s) {
        System.out.println(s);
    }
}