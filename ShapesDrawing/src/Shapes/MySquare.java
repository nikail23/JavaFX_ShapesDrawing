package Shapes;

import javafx.scene.paint.Color;
import java.awt.*;
import java.io.Serializable;

public class MySquare extends MyRectangle implements Serializable {
    public MySquare(String name, Point firstPoint, Point secondPoint, Color color, int thickness) {
        super(name, firstPoint, secondPoint, color, thickness);
        if (width > height)
            width = height;
        else
            height = width;
    }
}
