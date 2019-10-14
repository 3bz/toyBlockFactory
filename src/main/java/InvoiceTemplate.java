public class InvoiceTemplate {
    private String[][] message;

    public InvoiceTemplate() {
        message = new String[Shape.values().length+1][Color.values().length+1];
        for (int a = 0; a < message.length; a++) {
            for (int b = 0; b < message.length; b++) {
                message[a][b] = ".";
            }
        }

        for (int i = 0; i < Shape.values().length + 1; i++) {
            if (i < 1) {
                for (int j = 1; j < Color.values().length + 1; j++) {
                    message[i][j] = Color.values()[j-1].name();
                }
            } else {
                for (int k = 0; k < Color.values().length; k++) {
                    message[i][k] = Shape.values()[i-1].name();
                    break;
                }
            }
        }
    }

    public String[][] getMessage() {
        return message;
    }

//    public void print() {
//        for (int xAxis = 0; xAxis < message.length; xAxis++) {
//            for (int yAxis = 0; yAxis < message.length; yAxis++) {
//                System.out.print(message[xAxis][yAxis]);
//            }
//            System.out.println("\n");
//        }
//    }

}
