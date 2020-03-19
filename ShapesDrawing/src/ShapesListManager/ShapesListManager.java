package ShapesListManager;

import Shapes.MyShape;
import ShapesListManager.Serializer.Serializer;
import javafx.scene.canvas.Canvas;

import java.util.List;

public class ShapesListManager implements ListManager {
    private List<MyShape> currentShapes;
    private List<MyShape> deletedShapes;
    private Serializer serializer;

    public ShapesListManager(List<MyShape> currentShapes, List<MyShape> deletedShapes, Serializer serializer) {
        this.currentShapes = currentShapes;
        this.deletedShapes = deletedShapes;
        this.serializer = serializer;
    }

    public void Add(MyShape shape) {
        if (shape != null)
            currentShapes.add(shape);
    }

    public void Delete(int shapeIndex) {
        if ((shapeIndex >= 0)&&(shapeIndex < currentShapes.size())) {
            deletedShapes.add(currentShapes.get(shapeIndex));
            currentShapes.remove(shapeIndex);
        }
    }

    public void LoadList() {
        currentShapes = serializer.Deserialize();
    }

    public List<MyShape> GetList() {
        return currentShapes;
    }

    public void SaveList() {
        serializer.Serialize(currentShapes);
    }

    public void DrawAllShapes(Canvas canvas) {
        for (MyShape shape : currentShapes) {
            shape.draw(canvas);
        }
    }

    public void Undo() {
        if (currentShapes.size() != 0) {
            int currentShapesLastIndex = currentShapes.size()-1;
            Delete(currentShapesLastIndex);
        }
    }

    public void Redo() {
        if (deletedShapes.size() != 0) {
            int deletedShapesLastIndex = deletedShapes.size() - 1;
            Add(deletedShapes.get(deletedShapesLastIndex));
            deletedShapes.remove(deletedShapesLastIndex);
        }
    }

    public void ClearCurrentShapesList() {
        currentShapes.clear();
    }

    public void ClearDeletedShapesList() {
        deletedShapes.clear();
    }
}
