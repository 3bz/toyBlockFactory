import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory() {
        cuttingDepartment = new CuttingDepartment();
        paintingDepartment = new PaintingDepartment();
    }

    public List<Block> requestShapesCut(List<CuttingOrder> aOrder){
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder cuttingOrder : aOrder)
            blocksCut.addAll(cuttingDepartment.fulfillCuttingOrder(cuttingOrder));

        return blocksCut;
    }

    public void requestBlocksPainted(List<PaintingOrder> aOrder) {
        List<Block> blocksPainted = new ArrayList<>();
        for(PaintingOrder paintingOrder : aOrder)
            blocksPainted.addAll(paintingDepartment.fullfilPaintingOrder(paintingOrder));
    }

    //MUST CONVERT CUSTOMER ORDER TO Cutting Orders and Painting Orders
}

