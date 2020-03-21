package GuiManager;

import Shapes.MyShape;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;

import java.util.List;

public interface GuiManager {
    void RefreshShapesListView(List<MyShape> currentShapes, ListView<String> listView);

    void ShowShapesProperties(int shapeIndex, List<MyShape> currentShapes, ListView<String> propertyList, ListView<String> propertyNameList);

    void ConfirmShapeChanges(ListView<String> propertyList, String newValue, int index);

    void DrawAllShapes(List<MyShape> currentShapes, Canvas canvas);
}
