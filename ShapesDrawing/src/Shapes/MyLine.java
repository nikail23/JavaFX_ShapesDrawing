package Shapes;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class MyLine extends MyShape {
    protected Point firstPoint;
    protected Point secondPoint;

    public MyLine(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, shapeColor, shapeThickness);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(shapeColor);
        graphicsContext.setLineWidth(shapeThickness);
        graphicsContext.beginPath();
        graphicsContext.moveTo(firstPoint.x, firstPoint.y);
        graphicsContext.lineTo(secondPoint.x, secondPoint.y);
        graphicsContext.stroke();
    }
}
