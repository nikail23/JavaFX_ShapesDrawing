package sample;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import GuiManager.GuiManager;
import GuiManager.MyGuiManager;
import ShapeFormer.MyShapeFormer;
import ShapeFormer.ShapeFormer;
import Shapes.MyShape;
import ShapesListManager.Serializer.BinarySerializer;
import ShapesListManager.MyShapesListManager;
import ShapesListManager.ShapesListManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;

public class Controller {
    private static int shapesLimit = 100;
    private ShapesListManager shapesListManager;
    private ShapeFormer shapeFormer;
    private GuiManager guiManager;

    public Controller() {
        shapesListManager = new MyShapesListManager(new ArrayList<MyShape>(), new ArrayList<MyShape>(), new BinarySerializer("save.bin"));
        shapeFormer = new MyShapeFormer();
        guiManager = new MyGuiManager();
    }

    private void ClearCanvas(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void ClearPropertyList() {
        propertyList.getItems().clear();
        propertyNameList.getItems().clear();
    }

    private void ShowShapesLimitMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Внимание!");
        alert.setHeaderText(null);
        alert.setContentText("Вы достигли предельного количества фигур!");
        alert.showAndWait();
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
    private ListView<String> shapesList;

    @FXML
    private ListView<String> propertyList;

    @FXML
    private Button clearButton;

    @FXML
    private ListView<String> propertyNameList;

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
        assert propertyList != null : "fx:id=\"propertyList\" was not injected: check your FXML file 'sample.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert propertyNameList != null : "fx:id=\"propertyNameList\" was not injected: check your FXML file 'sample.fxml'.";
        propertyList.setCellFactory(TextFieldListCell.forListView());
        propertyList.setOnEditCommit(event -> {
            ClearCanvas(drawingCanvas);
            guiManager.ConfirmShapeChanges(propertyList, event.getNewValue(), event.getIndex());
            guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
            guiManager.DrawAllShapes(shapesListManager.GetList(), drawingCanvas);
        });
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
            if (shapesListManager.GetList().size() < shapesLimit) {
                ClearPropertyList();
                shapeFormer.SetSecondPoint(new Point(GetClickPoint(event)));
                shapesListManager.Add(shapeFormer.CreateShape());
                guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
                guiManager.DrawAllShapes(shapesListManager.GetList(), drawingCanvas);
            } else {
                ShowShapesLimitMessage();
            }
        });
        colorDialog.setOnAction(event -> {
            shapeFormer.SetShapeColor(colorDialog.getValue());
        });
        thicknessBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            int ShapeThicknessValue = newValue.intValue();
            shapeFormer.SetShapeThickness(ShapeThicknessValue);
            String StringShapeThicknessValue = String.valueOf(newValue.intValue());
            thicknessValue.setText(StringShapeThicknessValue);
        });
        undoButton.setOnAction(event -> {
            shapesListManager.Undo();
            ClearCanvas(drawingCanvas);
            guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
            ClearPropertyList();
            guiManager.DrawAllShapes(shapesListManager.GetList(), drawingCanvas);
        });
        redoButton.setOnAction(event -> {
            ClearCanvas(drawingCanvas);
            ClearPropertyList();
            shapesListManager.Redo();
            guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
            guiManager.DrawAllShapes(shapesListManager.GetList(), drawingCanvas);
        });
        saveButton.setOnAction(event -> {
            shapesListManager.SaveList();
        });
        loadButton.setOnAction(event -> {
            ClearPropertyList();
            shapesListManager.ClearDeletedShapesList();
            shapesListManager.LoadList();
            guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
            guiManager.DrawAllShapes(shapesListManager.GetList(), drawingCanvas);
        });
        clearButton.setOnAction(event -> {
            ClearPropertyList();
            ClearCanvas(drawingCanvas);
            shapesListManager.ClearCurrentShapesList();
            shapesListManager.ClearDeletedShapesList();
            guiManager.RefreshShapesListView(shapesListManager.GetList(), shapesList);
        });
        shapesList.setOnMouseClicked(event -> {
            guiManager.ShowShapesProperties(shapesList.getSelectionModel().getSelectedIndex(), shapesListManager.GetList(), propertyList, propertyNameList);
        });
    }
}
