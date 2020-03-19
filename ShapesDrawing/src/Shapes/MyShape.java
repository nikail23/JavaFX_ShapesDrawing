package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


import java.io.Serializable;

public abstract class MyShape implements Serializable {
    protected String name;
    private int shapeColor;
    protected int shapeThickness;

    public MyShape(String name, Color shapeColor, int shapeThickness) {
        this.name = name;
        this.shapeColor = (int) (shapeColor.getRed() * 0xFF) |
                ((int) (shapeColor.getGreen() * 0xFF)) << 010 |
                ((int) (shapeColor.getBlue() * 0xFF)) << 020 |
                ((int) (shapeColor.getOpacity() * 0xFF)) << 030;
        this.shapeThickness = shapeThickness;
    }

    public Color GetColor() {
        return Color.rgb(
                shapeColor & 0xFF,
                (shapeColor >>> 010) & 0xFF,
                (shapeColor >>> 020) & 0xFF,
                (shapeColor >>> 030) / 255d);
    }

    public abstract void draw(Canvas canvas);
}
