package ShapesListManager;

import Shapes.MyShape;

import java.util.ArrayList;
import java.util.List;

public class ShapesListManager implements ListManager {
    private List<MyShape> currentShapes;
    private List<MyShape> deletedShapes;
    public ShapesListManager(List<MyShape> currentShapes, List<MyShape> deletedShapes)
    {
        this.currentShapes = currentShapes;
        this.deletedShapes = deletedShapes;
    }
    public void Add(MyShape shape) {
        currentShapes.add(shape);
    }
    public void Delete(int shapeIndex) {
        if (shapeIndex >= 0)
            currentShapes.remove(shapeIndex);
    }
    public void LoadList() {
        //
    }
    public List<MyShape> GetList() {
        return currentShapes;
    }
    public void SaveList() {
        //
    }
}
