import io.IInput;

public class StubInput implements IInput {
    @Override
    public int takeInteger() {
        return 1;
    }

    @Override
    public String takeString() {
        return "test";
    }
}