import services.factory.Block;
import services.factory.ToyBlockFactory;
import services.factory.cutting.CuttingOrder;
import services.factory.cutting.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CuttingDepartmentReturns {
    private ToyBlockFactory testFactory;
    private List<CuttingOrder> cuttingOrder;

    @Before
    public void init(){
        testFactory = new ToyBlockFactory();

        cuttingOrder = new ArrayList<>();
        cuttingOrder.add(new CuttingOrder(Shape.SQUARE, 2));
        cuttingOrder.add(new CuttingOrder(Shape.CIRCLE, 3));
        cuttingOrder.add(new CuttingOrder(Shape.TRIANGLE, 2));
    }

    @Test
    public void manyDifferentShapesCut() {
        List<Block> testShapesCut = testFactory.requestShapesCut(cuttingOrder);

        Assert.assertEquals(7, testShapesCut.size());
    }

    @Test
    public void shapesInSpecifiedArrangement() {
        List<Block> testShapesOrder = testFactory.requestShapesCut(cuttingOrder);
        Block actual = testShapesOrder.get(2);

        Assert.assertEquals(actual.getShape(), Shape.CIRCLE);
    }
}