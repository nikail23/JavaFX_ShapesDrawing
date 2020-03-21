package ShapeFormer;

import Shapes.MyShape;
import javafx.scene.paint.Color;

import java.awt.*;

public interface ShapeFormer {
    void SetFirstPoint(Point firstPoint);

    void SetSecondPoint(Point secondPoint);

    void SetShapeTag(int shapeTag);

    void SetShapeColor(Color shapeColor);

    void SetShapeThickness(int shapeThickness);

    MyShape CreateShape();
}
