package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public abstract class MyShape {
    protected String name;
    protected Color shapeColor;
    protected int shapeThickness;

    public MyShape(String name, Color shapeColor, int shapeThickness) {
        this.name = name;
        this.shapeColor = shapeColor;
        this.shapeThickness = shapeThickness;
    }

    public abstract void draw(Canvas canvas);
}
