package Shapes;

import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;

public class MyCircle extends MyEllipse implements Serializable {
    public MyCircle(String name, Point firstPoint, Point secondPoint, Color shapeColor, int shapeThickness) {
        super(name, firstPoint, secondPoint, shapeColor, shapeThickness);
        if (width > height)
            width = height;
        else
            height = width;
    }
}
