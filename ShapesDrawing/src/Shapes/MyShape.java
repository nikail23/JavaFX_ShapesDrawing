package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.Serializable;

public abstract class MyShape extends Object implements Serializable {
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
