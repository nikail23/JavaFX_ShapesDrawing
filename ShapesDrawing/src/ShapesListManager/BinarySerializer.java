package ShapesListManager;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class BinarySerializer implements Serializer{
    private String path;
    public BinarySerializer(String path)
    {
        this.path = path;
    }
    public void Serialize(List list) {
        if (path != null)
        {
        }
    }
    public List Deserialize() {
        return null;
    }
}
