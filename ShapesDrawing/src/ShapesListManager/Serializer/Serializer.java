package ShapesListManager.Serializer;

import Shapes.MyShape;
import ShapesListManager.ShapesListManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Serializer {
    void Serialize(List<MyShape> list);

    List<MyShape> Deserialize();
}
