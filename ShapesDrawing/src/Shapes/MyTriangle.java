package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;

public class MyTriangle extends MyShape implements Serializable {
    protected Point firstTrianglePoint;
    protected Point secondTrianglePoint;
    protected Point thirdTrianglePoint;

    public MyTriangle(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, shapeColor, shapeThickness);
        firstTrianglePoint = new Point();
        secondTrianglePoint = new Point();
        thirdTrianglePoint = new Point();
        GetTrianglePoints(firstPoint, secondPoint);
    }

    public void SetTriangleFirstPoint(Point firstTrianglePoint) {
        if ((firstTrianglePoint != null) && (firstTrianglePoint.x >= 0) && (firstTrianglePoint.y >= 0)) {
            this.firstTrianglePoint = firstTrianglePoint;
        }
    }

    public Point GetTriangleFirstPoint() {
        return this.firstTrianglePoint;
    }

    public void SetTriangleSecondPoint(Point secondTrianglePoint) {
        if ((secondTrianglePoint != null) && (secondTrianglePoint.x >= 0) && (secondTrianglePoint.y >= 0)) {
            this.secondTrianglePoint = secondTrianglePoint;
        }
    }

    public Point GetTriangleSecondPoint() {
        return this.secondTrianglePoint;
    }

    public void SetTriangleThirdPoint(Point thirdTrianglePoint) {
        if ((thirdTrianglePoint != null) && (thirdTrianglePoint.x >= 0) && (thirdTrianglePoint.y >= 0)) {
            this.thirdTrianglePoint = thirdTrianglePoint;
        }
    }

    public Point GetTriangleThirdPoint() {
        return this.thirdTrianglePoint;
    }

    private void GetTrianglePoints(Point firstPoint, Point secondPoint) {
        if ((firstPoint.x < secondPoint.x) && (firstPoint.y < secondPoint.y)) {
            firstTrianglePoint.x = Math.abs((firstPoint.x - secondPoint.x) / 2) + firstPoint.x;
            firstTrianglePoint.y = firstPoint.y;
            secondTrianglePoint.x = firstPoint.x;
            secondTrianglePoint.y = secondPoint.y;
            thirdTrianglePoint.x = secondPoint.x;
            thirdTrianglePoint.y = secondPoint.y;
        } else if ((firstPoint.x < secondPoint.y) && (firstPoint.y > secondPoint.y)) {
            firstTrianglePoint.x = Math.abs((firstPoint.x - secondPoint.x) / 2) + firstPoint.x;
            firstTrianglePoint.y = secondPoint.y;
            secondTrianglePoint.x = firstPoint.x;
            secondTrianglePoint.y = firstPoint.y;
            thirdTrianglePoint.x = secondPoint.x;
            thirdTrianglePoint.y = firstPoint.y;
        } else if ((firstPoint.x > secondPoint.x) && (firstPoint.y < secondPoint.y)) {
            firstTrianglePoint.x = firstPoint.x - Math.abs((firstPoint.x - secondPoint.x) / 2);
            firstTrianglePoint.y = firstPoint.y;
            secondTrianglePoint.x = secondPoint.x;
            secondTrianglePoint.y = secondPoint.y;
            thirdTrianglePoint.x = firstPoint.x;
            thirdTrianglePoint.y = secondPoint.y;
        } else {
            firstTrianglePoint.x = firstPoint.x - Math.abs((firstPoint.x - secondPoint.x) / 2);
            firstTrianglePoint.y = secondPoint.y;
            secondTrianglePoint.x = secondPoint.x;
            secondTrianglePoint.y = firstPoint.y;
            thirdTrianglePoint.x = firstPoint.x;
            thirdTrianglePoint.y = firstPoint.y;
        }
    }

    @Override
    public void Draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(GetColor());
        graphicsContext.setLineWidth(shapeThickness);
        graphicsContext.beginPath();
        graphicsContext.moveTo(firstTrianglePoint.x, firstTrianglePoint.y);
        graphicsContext.lineTo(secondTrianglePoint.x, secondTrianglePoint.y);
        graphicsContext.lineTo(thirdTrianglePoint.x, thirdTrianglePoint.y);
        graphicsContext.lineTo(firstTrianglePoint.x, firstTrianglePoint.y);
        graphicsContext.stroke();
    }
}
