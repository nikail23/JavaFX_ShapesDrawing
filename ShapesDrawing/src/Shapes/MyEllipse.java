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
        graphicsContext.setFill(shapeColor);
        graphicsContext.fillOval(x, y, width, height);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(x + shapeThickness, y + shapeThickness, width - 2 * shapeThickness, height - 2 * shapeThickness);
    }
}
