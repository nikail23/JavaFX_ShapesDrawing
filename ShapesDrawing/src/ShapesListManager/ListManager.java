package ShapesListManager;

import Shapes.MyShape;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.util.List;

public interface ListManager {
    void Add(MyShape listElement);

    void Delete(int listIndex);

    void LoadList();

    List<MyShape> GetList();

    void SaveList();

    void Undo();

    void Redo();

    void ClearCurrentShapesList();

    void ClearDeletedShapesList();

    void RefreshListView(ListView<String> listView);

    void ShowShapesProperties(int shapeIndex, ListView<String> propertyList, ListView<String> propertyNameList);
}
