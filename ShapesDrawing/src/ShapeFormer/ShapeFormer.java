package ShapeFormer;

import Shapes.MyShape;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Dictionary;

public class ShapeFormer {
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
    public ShapeFormer()
    {
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
    private void AddShapesToDictionary()
    {
        shapesDictionary = new Dictionary<int, MyShape>();
        shapesDictionary.Add(1, new Circle(startPoint, finishPoint, color, thickness, "Circle"));
        shapesDictionary.Add(2, new Square(startPoint, finishPoint, color, thickness, "Square"));
        shapesDictionary.Add(3, new Rectangle(startPoint, finishPoint, color, thickness, "Rectangle"));
        shapesDictionary.Add(4, new Triangle(startPoint, finishPoint, color, thickness, "Triangle"));
        shapesDictionary.Add(5, new Ellipse(startPoint, finishPoint, color, thickness, "Ellipse"));
        shapesDictionary.Add(6, new Line(startPoint, finishPoint, color, thickness, "Line"));
    }
    MyShape CreateShape() {
        
    }
}
