package ShapesListManager.Serializer;

import Shapes.MyShape;

import java.util.List;

public interface Serializer {
    void Serialize(List<MyShape> list);

    List<MyShape> Deserialize();
}
