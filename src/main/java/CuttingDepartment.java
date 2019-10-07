public class CuttingDepartment {
    private ICutShapes workers;

    public CuttingDepartment() {
        workers = new BlockCutter();
    }

    public Block cutShape(Shape blockShape){
        return workers.cutBlock(blockShape);
    }
}
