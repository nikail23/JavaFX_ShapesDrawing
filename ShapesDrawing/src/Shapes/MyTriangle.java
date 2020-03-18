package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.*;

public class MyTriangle extends MyLine {
    protected Point firstTrianglePoint;
    protected Point secondTrianglePoint;
    protected Point thirdTrianglePoint;
    public MyTriangle(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, firstPoint, secondPoint, shapeColor, shapeThickness);
        firstTrianglePoint = new Point();
        secondTrianglePoint = new Point();
        thirdTrianglePoint = new Point();
        GetTrianglePoints();
    }

    private void GetTrianglePoints() {
        if ((firstPoint.x < secondPoint.x) && (firstPoint.y < secondPoint.y))
        {
            firstTrianglePoint.x = Math.abs((firstPoint.x - secondPoint.x) / 2) + firstPoint.x;
            firstTrianglePoint.y = firstPoint.y;
            secondTrianglePoint.x = firstPoint.x;
            secondTrianglePoint.y = secondPoint.y;
            thirdTrianglePoint.x = secondPoint.x;
            thirdTrianglePoint.y = secondPoint.y;
        }
        else if ((firstPoint.x < secondPoint.y) && (firstPoint.y > secondPoint.y))
        {
            firstTrianglePoint.x = Math.abs((firstPoint.x - secondPoint.x) / 2) + firstPoint.x;
            firstTrianglePoint.y = secondPoint.y;
            secondTrianglePoint.x = firstPoint.x;
            secondTrianglePoint.y = firstPoint.y;
            thirdTrianglePoint.x = secondPoint.x;
            thirdTrianglePoint.y = firstPoint.y;
        }
        else if ((firstPoint.x > secondPoint.x) && (firstPoint.y < secondPoint.y))
        {
            firstTrianglePoint.x = firstPoint.x - Math.abs((firstPoint.x - secondPoint.x )/ 2);
            firstTrianglePoint.y = firstPoint.y;
            secondTrianglePoint.x = secondPoint.x;
            secondTrianglePoint.y = secondPoint.y;
            thirdTrianglePoint.x = firstPoint.x;
            thirdTrianglePoint.y = secondPoint.y;
        }
        else
        {
            firstTrianglePoint.x = firstPoint.x - Math.abs((firstPoint.x - secondPoint.x) / 2);
            firstTrianglePoint.y = secondPoint.y;
            secondTrianglePoint.x = secondPoint.x;
            secondTrianglePoint.y = firstPoint.y;
            thirdTrianglePoint.x = firstPoint.x;
            thirdTrianglePoint.y = firstPoint.y;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(shapeColor);
        graphicsContext.setLineWidth(shapeThickness);
        graphicsContext.beginPath();
        graphicsContext.moveTo(firstTrianglePoint.x, firstTrianglePoint.y);
        graphicsContext.lineTo(secondTrianglePoint.x, secondTrianglePoint.y);
        graphicsContext.lineTo(thirdTrianglePoint.x, thirdTrianglePoint.y);
        graphicsContext.lineTo(firstTrianglePoint.x, firstTrianglePoint.y);
        graphicsContext.stroke();
    }
}
