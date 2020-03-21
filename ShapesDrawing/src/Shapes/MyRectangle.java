package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;

public class MyRectangle extends MyShape implements Serializable {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public MyRectangle(String name, Point firstPoint, Point secondPoint, Color color, int thickness) {
        super(name, color, thickness);
        this.x = firstPoint.x;
        this.y = firstPoint.y;
        this.width = secondPoint.x - firstPoint.x;
        this.height = secondPoint.y - firstPoint.y;
        if ((this.width < 0)) {
            this.x = secondPoint.x;
        }
        if ((this.height < 0)) {
            this.y = secondPoint.y;
        }
        this.width = Math.abs(this.width);
        this.height = Math.abs(this.height);
    }

    public void SetX(int x) {
        if (x >= 0) {
            this.x = x;
        }
    }

    public int GetX() {
        return this.x;
    }

    public void SetY(int y) {
        if (y >= 0) {
            this.y = y;
        }
    }

    public int GetY() {
        return this.y;
    }

    public void SetWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    public int GetWidth() {
        return this.width;
    }

    public void SetHeight(int height) {
        if (height >= 0) {
            this.height = height;
        }
    }

    public int GetHeight() {
        return this.height;
    }

    @Override
    public void Draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(GetColor());
        graphicsContext.fillRect(x, y, width, height);
        graphicsContext.setFill(Color.WHITE);  // можно сделать цвет обводки и главный цвет отдельно
        graphicsContext.fillRect(x + shapeThickness, y + shapeThickness, width - 2 * shapeThickness, height - 2 * shapeThickness);
    }
}
