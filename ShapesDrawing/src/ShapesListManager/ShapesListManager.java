package ShapesListManager;

import Shapes.*;
import ShapesListManager.Serializer.Serializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;

import java.awt.*;
import java.util.List;

public class ShapesListManager implements ListManager {
    private List<MyShape> currentShapes;
    private List<MyShape> deletedShapes;
    private Serializer serializer;
    private MyShape currentShape;

    public ShapesListManager(List<MyShape> currentShapes, List<MyShape> deletedShapes, Serializer serializer) {
        this.currentShapes = currentShapes;
        this.deletedShapes = deletedShapes;
        this.serializer = serializer;
        this.currentShape = null;
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

    public void RefreshListView(ListView<String> listView) {
        listView.getItems().clear();
        for (MyShape shape: currentShapes) {
            listView.getItems().add(shape.GetName());
        }
    }

    public void SetCurrentShape(int shapeIndex) {
        currentShape = currentShapes.get(shapeIndex);
    }

    private ObservableList<String> GetShapePropertyObservableList() {
        ObservableList<String> properties = FXCollections.observableArrayList();
        properties.add(currentShape.GetName());
        properties.add(Integer.toHexString(currentShape.GetIntColor()));
        properties.add(String.valueOf(currentShape.GetThickness()));
        if (currentShape instanceof MyRectangle) {
            MyRectangle rectangle = (MyRectangle)currentShape;
            properties.add("" + rectangle.GetX());
            properties.add("" + rectangle.GetY());
            properties.add("" + rectangle.GetWidth());
            properties.add("" + rectangle.GetHeight());
        }
        if (currentShape instanceof MyLine) {
            MyLine line = (MyLine) currentShape;
            properties.add("" + line.GetFirstPoint().x);
            properties.add("" + line.GetFirstPoint().y);
            properties.add("" + line.GetSecondPoint().x);
            properties.add("" + line.GetSecondPoint().y);
        }
        if (currentShape instanceof MyTriangle) {
            MyTriangle triangle = (MyTriangle) currentShape;
            properties.add("" + triangle.GetTriangleFirstPoint().x);
            properties.add("" + triangle.GetTriangleFirstPoint().y);
            properties.add("" + triangle.GetTriangleSecondPoint().x);
            properties.add("" + triangle.GetTriangleSecondPoint().y);
            properties.add("" + triangle.GetTriangleThirdPoint().x);
            properties.add("" + triangle.GetTriangleThirdPoint().y);
        }
        return properties;
    }

    private ObservableList<String> GetShapePropertyNameObservableList() {
        ObservableList<String> properties = FXCollections.observableArrayList();
        properties.add("Name:");
        properties.add("Color:");
        properties.add("Thickness:");
        if (currentShape instanceof MyRectangle) {
            properties.add("X:");
            properties.add("Y:");
            properties.add("Width:");
            properties.add("Height:");
        }
        if (currentShape instanceof MyLine) {
            properties.add("X1:");
            properties.add("Y1:");
            properties.add("X2:");
            properties.add("Y2:");
        }
        if (currentShape instanceof MyTriangle) {
            properties.add("X1:");
            properties.add("Y1:");
            properties.add("X2:");
            properties.add("Y2:");
            properties.add("X3:");
            properties.add("Y3:");
        }
        return properties;
    }

    private void RefreshShapeProperties(ListView<String> propertyList) {
        propertyList.setItems(GetShapePropertyObservableList());
    }

    public void ShowShapesProperties(int shapeIndex, ListView<String> propertyList, ListView<String> propertyNameList) {
        SetCurrentShape(shapeIndex);
        propertyList.setItems(GetShapePropertyObservableList());
        propertyNameList.setItems(GetShapePropertyNameObservableList());
    }

    public void ConfirmShapeChanges(ListView<String> propertyList, String newValue, int index) {
        switch (index) {
            case 0:
                currentShape.SetName(newValue);
                break;
            case 1:
                currentShape.SetIntColor((int)Long.parseLong(newValue, 16));
                break;
            case 2:
                currentShape.SetThickness(Integer.parseInt(newValue));
                break;
        }
        if (currentShape instanceof MyRectangle) {
            MyRectangle rectangle = (MyRectangle) currentShape;
            switch (index) {
                case 3:
                    rectangle.SetX(Integer.parseInt(newValue));
                    break;
                case 4:
                    rectangle.SetY(Integer.parseInt(newValue));
                    break;
                case 5:
                    rectangle.SetWidth(Integer.parseInt(newValue));
                    break;
                case 6:
                    rectangle.SetHeight(Integer.parseInt(newValue));
                    break;
            }
        }
        if (currentShape instanceof MyLine) {
            MyLine line = (MyLine) currentShape;
            switch (index) {
                case 3:
                    line.SetFirstPoint(new Point(Integer.parseInt(newValue), line.GetFirstPoint().y));
                    break;
                case 4:
                    line.SetFirstPoint(new Point(line.GetFirstPoint().x, Integer.parseInt(newValue)));
                    break;
                case 5:
                    line.SetSecondPoint(new Point(Integer.parseInt(newValue), line.GetSecondPoint().y));
                    break;
                case 6:
                    line.SetSecondPoint(new Point(line.GetSecondPoint().x, Integer.parseInt(newValue)));
                    break;
            }
        }
        if (currentShape instanceof MyTriangle) {
            MyTriangle triangle = (MyTriangle) currentShape;
            switch (index) {
                case 3:
                    triangle.SetTriangleFirstPoint(new Point(Integer.parseInt(newValue), triangle.GetTriangleFirstPoint().y));
                    break;
                case 4:
                    triangle.SetTriangleFirstPoint(new Point(triangle.GetTriangleFirstPoint().x, Integer.parseInt(newValue)));
                    break;
                case 5:
                    triangle.SetTriangleSecondPoint(new Point(Integer.parseInt(newValue), triangle.GetTriangleSecondPoint().y));
                    break;
                case 6:
                    triangle.SetTriangleSecondPoint(new Point(triangle.GetTriangleSecondPoint().x, Integer.parseInt(newValue)));
                    break;
                case 7:
                    triangle.SetTriangleThirdPoint(new Point(Integer.parseInt(newValue), triangle.GetTriangleThirdPoint().y));
                    break;
                case 8:
                    triangle.SetTriangleThirdPoint(new Point(triangle.GetTriangleThirdPoint().x, Integer.parseInt(newValue)));
                    break;

            }
        }
        RefreshShapeProperties(propertyList);
    }

}
