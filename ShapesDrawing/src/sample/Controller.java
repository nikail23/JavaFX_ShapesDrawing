package sample;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ShapeFormer.ShapeFormer;
import Shapes.MyShape;
import ShapesListManager.ShapesListManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    private ShapesListManager shapesListManager;
    private ShapeFormer shapeFormer;

    public Controller() {
        shapesListManager = new ShapesListManager(new ArrayList<MyShape>(), new ArrayList<MyShape>());
        shapeFormer = new ShapeFormer();
    }

    private Point GetClickPoint(MouseEvent event) {
        return new Point((int) event.getX(), (int) event.getY());
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas drawingCanvas;

    @FXML
    private Button rectangleButton;

    @FXML
    private Button triangleButton;

    @FXML
    private Button circleButton;

    @FXML
    private Button ellipseButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button lineButton;

    @FXML
    private ColorPicker colorDialog;

    @FXML
    private Slider thicknessBar;

    @FXML
    private Button undoButton;

    @FXML
    private Button redoButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Label thicknessValue;

    @FXML
    private ListView<?> shapesList;

    @FXML
    private TableView<?> propertyTable;

    @FXML
    void initialize() {
        assert drawingCanvas != null : "fx:id=\"drawingCanvas\" was not injected: check your FXML file 'sample.fxml'.";
        assert rectangleButton != null : "fx:id=\"rectangleButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert triangleButton != null : "fx:id=\"triangleButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert circleButton != null : "fx:id=\"circleButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert ellipseButton != null : "fx:id=\"ellipseButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert squareButton != null : "fx:id=\"squareButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert lineButton != null : "fx:id=\"lineButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert colorDialog != null : "fx:id=\"colorDialog\" was not injected: check your FXML file 'sample.fxml'.";
        assert thicknessBar != null : "fx:id=\"thicknessBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert undoButton != null : "fx:id=\"undoButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert redoButton != null : "fx:id=\"redoButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert thicknessValue != null : "fx:id=\"thicknessValue\" was not injected: check your FXML file 'sample.fxml'.";
        assert shapesList != null : "fx:id=\"shapesList\" was not injected: check your FXML file 'sample.fxml'.";
        assert propertyTable != null : "fx:id=\"propertyTable\" was not injected: check your FXML file 'sample.fxml'.";
        rectangleButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(1);
        });
        triangleButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(2);
        });
        circleButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(3);
        });
        ellipseButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(4);
        });
        squareButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(5);
        });
        lineButton.setOnAction(e -> {
            shapeFormer.SetShapeTag(6);
        });
        drawingCanvas.setOnMousePressed(event -> {
            shapeFormer.SetFirstPoint(new Point(GetClickPoint(event)));
        });
        drawingCanvas.setOnMouseReleased(event -> {
            shapeFormer.SetSecondPoint(new Point(GetClickPoint(event)));
            shapesListManager.Add(shapeFormer.CreateShape());
            shapesListManager.DrawAllShapes(drawingCanvas);
        });
        colorDialog.setOnAction(event -> {
            shapeFormer.SetShapeColor(colorDialog.getValue());
        });
        thicknessBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int newShapeThickness = newValue.intValue();
                shapeFormer.SetShapeThickness(newShapeThickness);
                String stringShapeThickness = String.valueOf(newValue.intValue());
                thicknessValue.setText(stringShapeThickness);
            }
        });
    }
}
