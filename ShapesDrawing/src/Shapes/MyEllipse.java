package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;


public class MyEllipse extends MyRectangle {
    public MyEllipse(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, firstPoint, secondPoint, shapeColor, shapeThickness);
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(color);
        graphicsContext.fillOval(x, y, width, height);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(x + thickness, y + thickness, width - 2 * thickness, height - 2 * thickness);
    }
}
