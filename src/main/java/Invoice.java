public class Invoice {
    private String[][] message;

    public Invoice() {
        message = new InvoiceTemplate().getMessage();
    }

    public void populateSquareRow(int[] squares) {
        for (int i = 0; i < Color.values().length; i++)
            message[i+1][1] = String.valueOf(squares[i]);
    }

    public void populateTriangleRow(int[] squares) {
        for (int i = 0; i < Color.values().length; i++)
            message[i+1][2] = String.valueOf(squares[i]);
    }

    public void populateCircleRow(int[] circles) {
        for (int i = 0; i < Color.values().length; i++)
            message[i+1][3] = String.valueOf(circles[i]);
    }

//    public void populateShapeRow(int[] valuesOfShape, Shape shape) {
//        for (int i = 1; i < Color.values().length + 1; i++)
//            message[i][shape.getIndex()] = String.valueOf(valuesOfShape[i]);
//    }

    public String[][] getMessage() {
        return message;
    }
}
