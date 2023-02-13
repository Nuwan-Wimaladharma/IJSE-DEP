package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class MainViewController {

    @FXML
    private Button btnCircle;

    @FXML
    private Button btnDragToolBar;

    @FXML
    private Button btnEllipse;

    @FXML
    private Button btnEraser;

    @FXML
    private Button btnFillColorPicker;

    @FXML
    private Button btnPencil;

    @FXML
    private Button btnRectangle;

    @FXML
    private Button btnRoundedRectangle;
    @FXML
    private ColorPicker clrFill;

    @FXML
    private ColorPicker clrStroke;

    @FXML
    private Button btnStrokeColorPicker;

    @FXML
    private Button btnText;

    @FXML
    private Canvas cnvMain;

    private boolean rectangle = false;
    private boolean roundedRectangle = false;
    private boolean circle = false;
    private boolean ellipse = false;
    private boolean pencil = false;
    private boolean eraser = false;
    private boolean text = false;
    private boolean strokeColor = false;
    private boolean fillColor = false;
    private double mouseStartX;
    private double mouseStartY;
    private double width;
    private double height;


    @FXML
    void btnDragToolBarOnAction(ActionEvent event) {

    }

    @FXML
    void btnRectangleOnAction(ActionEvent event) {
        rectangle = true;
    }

    @FXML
    void btnRoundedRectangleOnAction(ActionEvent event) {

    }

    @FXML
    void btnCircleOnAction(ActionEvent event) {

    }

    @FXML
    void btnEllipseOnAction(ActionEvent event) {

    }

    @FXML
    void btnPencilOnAction(ActionEvent event) {

    }

    @FXML
    void btnEraserOnAction(ActionEvent event) {

    }

    @FXML
    void btnTextOnAction(ActionEvent event) {

    }

    @FXML
    void btnStrokeColorPickerOnAction(ActionEvent event) {
        strokeColor = true;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setStroke(clrStroke.getValue());
    }

    @FXML
    void btnFillColorOnAction(ActionEvent event) {
        fillColor = true;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(clrFill.getValue());
    }

    @FXML
    void cnvMainOnMouseClicked(MouseEvent event) {
    }

    @FXML
    void cnvMainOnMouseDragged(MouseEvent event) {
        if (rectangle){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;
            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.strokeRect(mouseStartX,mouseStartY,width,height);
                gc.fillRect(mouseStartX,mouseStartY,width,height);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.strokeRect((mouseStartX + width),mouseStartY,(-1 * width),height);
                gc.fillRect((mouseStartX + width),mouseStartY,(-1 * width),height);
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.strokeRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
                gc.fillRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.strokeRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
                gc.fillRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
            }
        }

    }

    @FXML
    void cnvMainOnMousePressed(MouseEvent event) {
        mouseStartX = event.getX();
        mouseStartY = event.getY();
    }

    @FXML
    void cnvMainOnMouseReleased(MouseEvent event) {
        if (rectangle){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;
            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.strokeRect(mouseStartX,mouseStartY,width,height);
                gc.fillRect(mouseStartX,mouseStartY,width,height);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.strokeRect((mouseStartX + width),mouseStartY,(-1 * width),height);
                gc.fillRect((mouseStartX + width),mouseStartY,(-1 * width),height);
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.strokeRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
                gc.fillRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.strokeRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
                gc.fillRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
            }
        }
    }

}

