package ShapeFormer;

import Shapes.*;
import javafx.scene.paint.Color;

import java.awt.*;

public class MyShapeFormer implements ShapeFormer {
    private static Point defaultFirstPoint = new Point(0, 0);
    private static Point defaultSecondPoint = new Point(0, 0);
    private static Color defaultShapeColor = Color.BLACK;
    private static int defaultShapeTag = 1;
    private static int defaultShapeThickness = 1;
    private Point firstPoint;
    private Point secondPoint;
    private int shapeTag;
    private Color shapeColor;
    private int shapeThickness;

    public MyShapeFormer() {
        firstPoint = defaultFirstPoint;
        secondPoint = defaultSecondPoint;
        shapeTag = defaultShapeTag;
        shapeColor = defaultShapeColor;
        shapeThickness = defaultShapeThickness;
    }

    public void SetFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void SetSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void SetShapeTag(int shapeTag) {
        this.shapeTag = shapeTag;
    }

    public void SetShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void SetShapeThickness(int shapeThickness) {
        this.shapeThickness = shapeThickness;
    }

    public MyShape CreateShape() {
        switch (shapeTag) {
            case 1:
                return new MyRectangle("Rectangle", firstPoint, secondPoint, shapeColor, shapeThickness);
            case 2:
                return new MyTriangle("Triangle", firstPoint, secondPoint, shapeColor, shapeThickness);
            case 3:
                return new MyCircle("Circle", firstPoint, secondPoint, shapeColor, shapeThickness);
            case 4:
                return new MyEllipse("Ellipse", firstPoint, secondPoint, shapeColor, shapeThickness);
            case 5:
                return new MySquare("Square", firstPoint, secondPoint, shapeColor, shapeThickness);
            case 6:
                return new MyLine("Line", firstPoint, secondPoint, shapeColor, shapeThickness);
        }
        return null;
    }
}
