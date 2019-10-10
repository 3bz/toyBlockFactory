public enum Color {
    RED(1),
    BLUE(0),
    YELLOW(0);

    private int price;

    Color(int i) {
        this.price = i;
    }

    public int getPrice() {
        return price;
    }
}