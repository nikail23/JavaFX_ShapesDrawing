package Shapes;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;

public class MyLine extends MyShape implements Serializable {
    protected Point firstPoint;
    protected Point secondPoint;

    public MyLine(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, shapeColor, shapeThickness);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public void SetFirstPoint(Point firstPoint) {
        if ((firstPoint != null) && (firstPoint.x >= 0) && (firstPoint.y >= 0)) {
            this.firstPoint = firstPoint;
        }
    }

    public Point GetFirstPoint() {
        return this.firstPoint;
    }

    public void SetSecondPoint(Point secondPoint) {
        if ((secondPoint != null) && (secondPoint.x >= 0) && (secondPoint.y >= 0)) {
            this.secondPoint = secondPoint;
        }
    }

    public Point GetSecondPoint() {
        return this.secondPoint;
    }

    @Override
    public void Draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(GetColor());
        graphicsContext.setLineWidth(shapeThickness);
        graphicsContext.beginPath();
        graphicsContext.moveTo(firstPoint.x, firstPoint.y);
        graphicsContext.lineTo(secondPoint.x, secondPoint.y);
        graphicsContext.stroke();
    }
}
