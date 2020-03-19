package ShapesListManager;

import Shapes.MyShape;
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
}
