package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public abstract class MyShape {
    protected String name;
    protected Color color;
    protected int thickness;

    public MyShape(String name, Color color, int thickness) {
        this.name = name;
        this.color = color;
        this.thickness = thickness;
    }

    public abstract void draw(Canvas canvas);
}
