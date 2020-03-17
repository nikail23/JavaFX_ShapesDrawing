package ShapesListManager;

import java.util.List;

public interface Serializer {
    void Serialize(List list);

    List Deserialize();
}
