import java.util.ArrayList;
import java.util.List;

public class ToyBlockFactory {
    private CuttingDepartment cuttingDepartment;

    public ToyBlockFactory(){
        cuttingDepartment = new CuttingDepartment();
    }

    public List<Block> requestShapesCut(List<CuttingOrder> aOrder){
        List<Block> blocksCut = new ArrayList<Block>();
        for (CuttingOrder cuttingOrder : aOrder)
            blocksCut.addAll(cuttingDepartment.fulfillOrder(cuttingOrder));

        return blocksCut;
    }
}
