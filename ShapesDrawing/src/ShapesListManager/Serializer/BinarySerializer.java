package ShapesListManager.Serializer;

import Shapes.MyShape;
import ShapesListManager.ShapesListManager;

import java.io.*;
import java.util.List;

public class BinarySerializer implements Serializer {
    private String savePath;

    public BinarySerializer(String path) {
        this.savePath = path;
    }

    public void Serialize(List<MyShape> list) {
        if (savePath != null) {
            try (FileOutputStream outputStream = new FileOutputStream(savePath)) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                    objectOutputStream.writeObject(list);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<MyShape> Deserialize() {
        try (FileInputStream fileInputStream = new FileInputStream(savePath)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (List<MyShape>)objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
