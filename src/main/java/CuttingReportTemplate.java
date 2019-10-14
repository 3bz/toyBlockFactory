public class CuttingReportTemplate {
    private String[][] message;

    public CuttingReportTemplate() {
        message = new String[2][Shape.values().length + 2];

//        message[0][0] = Accountant.fixedLengthString("|", 8);
//        message[0][1] = Accountant.fixedLengthString("| Qty", 7) + "|";
//        message[1][0] = Accountant.fixedLengthString("", 8).replace(' ', '-');
//        message[1][1] = Accountant.fixedLengthString("", 8).replace(' ', '-');

        for (int i = 2; i < Shape.values().length + 2; i ++) {
            message[0][i] = Shape.values()[i-2].name();
        }
    }
}
