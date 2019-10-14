import org.junit.Assert;
import org.junit.Test;

public class TestInvoice {

    @Test
    public void invoiceRowContainsAllColors() {
        Invoice invoice = new Invoice();

        for (int i = 1; i < Color.values().length + 1; i++){
            Assert.assertEquals(Color.values()[i-1].name(), invoice.getMessage()[0][i]);
        }
    }

    @Test
    public void invoiceColumnContainsAllShapes() {
        Invoice invoice = new Invoice();

        for (int i = 1; i < Shape.values().length + 1; i++){
            Assert.assertEquals(Shape.values()[i-1].name(), invoice.getMessage()[i][0]);
        }
    }

    @Test
    public void squareRowIsPopulated() {
        int[] squares = new int[]{1,2,3};
        Invoice invoice = new Invoice();

        invoice.populateSquareRow(squares);

        Assert.assertEquals("1", invoice.getMessage()[1][1]);
        Assert.assertEquals("2", invoice.getMessage()[2][1]);
        Assert.assertEquals("3", invoice.getMessage()[3][1]);
    }

    @Test
    public void triangleRowIsPopulated() {
        int[] triangles = new int[]{1,2,3};
        Invoice invoice = new Invoice();

        invoice.populateTriangleRow(triangles);

        Assert.assertEquals("1", invoice.getMessage()[1][2]);
        Assert.assertEquals("2", invoice.getMessage()[2][2]);
        Assert.assertEquals("3", invoice.getMessage()[3][2]);
    }

//    @Test
//    public void circleRowIsPopulated() {
//        int[] circles = new int[]{1,2,3};
//        Invoice invoice = new Invoice();
//
//        invoice.populateShapeRow(circles, Shape.CIRCLE);
//
//        Assert.assertEquals("1", invoice.getMessage()[1][3]);
//        Assert.assertEquals("2", invoice.getMessage()[2][3]);
//        Assert.assertEquals("3", invoice.getMessage()[3][3]);
//    }
}
