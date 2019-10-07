import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;
    private PaintingDepartment paintingDepartment;

    public ToyBlockFactory(){
        cuttingDepartment = new CuttingDepartment();
    }

    public List<Block> requestShapesCut(List<CuttingOrder> aOrder){
        List<Block> blocksCut = new ArrayList<>();
        for (CuttingOrder cuttingOrder : aOrder)
            blocksCut.addAll(cuttingDepartment.fulfillOrder(cuttingOrder));

        return blocksCut;
    }

    public void requestBlocksPainted(List<PaintingOrder> aOrder, List<Blocks> blockToBePainted) {
        for (PaintingOrder order: aOrder) {

        }
    }
}
