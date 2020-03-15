package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends MyShape {
    private int x;
    private int y;
    private int width;
    private int height;
    public MyRectangle(int x, int y, int width, int height, Color color, int thickness) {
        super("Rectangle", color, thickness);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    @Override public void draw(Canvas canvas)
    {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(thickness);
        graphicsContext.setFill(color);
    }
}
