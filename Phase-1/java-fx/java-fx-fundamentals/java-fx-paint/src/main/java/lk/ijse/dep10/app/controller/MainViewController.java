package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainViewController {

    public TextField txtTextField;
    public ToolBar tbToolBar;
    @FXML
    private TextArea txtTextArea;
    @FXML
    private Button btnClearAll;
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
    private boolean clearAll = false;
    private double mouseStartX;
    private double mouseStartY;
    private double startingXOfTextBox;
    private double startingYOfTextBox;
    private double width;
    private double height;
    private String typedText = "";
    private WritableImage snapshot;

    public void initialize(){
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());

        txtTextArea.textProperty().addListener((value, previous, current) -> {
            typedText = "";
            typedText += current;
        });
    }


    @FXML
    void btnDragToolBarOnAction(ActionEvent event) {
    }

    @FXML
    void btnRectangleOnAction(ActionEvent event) {
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        rectangle = true;
        roundedRectangle = false;
        ellipse = false;
        pencil = false;
        eraser = false;
        text = false;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
    }

    @FXML
    void btnRoundedRectangleOnAction(ActionEvent event) {
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        roundedRectangle = true;
        rectangle = false;
        ellipse = false;
        pencil = false;
        eraser = false;
        text = false;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
    }

    @FXML
    void btnCircleOnAction(ActionEvent event) {
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        circle = true;
        rectangle = false;
        roundedRectangle = false;
        ellipse = false;
        pencil = false;
        eraser = false;
        text = false;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
    }

    @FXML
    void btnEllipseOnAction(ActionEvent event) {
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        ellipse = true;
        rectangle = false;
        roundedRectangle = false;
        circle = false;
        pencil = false;
        eraser = false;
        text = false;
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
    }

    @FXML
    void btnPencilOnAction(ActionEvent event) {
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        pencil = true;
        rectangle = false;
        roundedRectangle = false;
        circle = false;
        ellipse = false;
        eraser = false;
        text = false;
    }

    @FXML
    void btnEraserOnAction(ActionEvent event) {
        txtTextArea.setVisible(false);
        txtTextArea.setDisable(true);
        eraser = true;
        rectangle = false;
        roundedRectangle = false;
        circle = false;
        ellipse = false;
        pencil = false;
        text = false;
        Image image = new Image("/img/eraserOnAction.png");
        cnvMain.getScene().setCursor(new ImageCursor(image));
    }

    @FXML
    void btnTextOnAction(ActionEvent event) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        text = true;
        rectangle = false;
        roundedRectangle = false;
        ellipse = false;
        circle = false;
        pencil = false;
        eraser = false;
        clearAll = false;

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
    void btnClearAllOnAction(ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        cnvMain.getScene().setCursor(Cursor.DEFAULT);
        clearAll = true;
        rectangle = false;
        roundedRectangle = false;
        ellipse = false;
        circle = false;
        pencil = false;
        eraser = false;
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,cnvMain.getWidth(),cnvMain.getHeight());
    }

    @FXML
    public void cnvMainOnMouseClicked(MouseEvent event) {
        if (text){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            startingXOfTextBox = event.getX();
            startingYOfTextBox = event.getY();
            txtTextArea.setVisible(true);
            txtTextArea.setDisable(false);
            gc.strokeText(typedText,txtTextArea.getLayoutX()+5,txtTextArea.getLayoutY()+15);
            txtTextArea.setLayoutX(startingXOfTextBox);
            txtTextArea.setLayoutY(startingYOfTextBox);
            txtTextArea.clear();
            typedText = "";
        }
    }

    @FXML
    public void cnvMainOnMouseDragged(MouseEvent event) {
        if (rectangle){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;
            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRect(mouseStartX,mouseStartY,width,height);
                gc.fillRect(mouseStartX,mouseStartY,width,height);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRect((mouseStartX + width),mouseStartY,(-1 * width),height);
                gc.fillRect((mouseStartX + width),mouseStartY,(-1 * width),height);
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
                gc.fillRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
                gc.fillRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
            }
        }
        if (roundedRectangle){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;
            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRoundRect(mouseStartX,mouseStartY,width,height,20,20);
                gc.fillRoundRect(mouseStartX,mouseStartY,width,height,20,20);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRoundRect((mouseStartX + width),mouseStartY,(-1 * width),height,20,20);
                gc.fillRoundRect((mouseStartX + width),mouseStartY,(-1 * width),height,20,20);
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRoundRect(mouseStartX,(mouseStartY+height),width,(-1 * height),20,20);
                gc.fillRoundRect(mouseStartX,(mouseStartY+height),width,(-1 * height),20,20);
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeRoundRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height),20,20);
                gc.fillRoundRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height),20,20);
            }
        }
        if (circle){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;

            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval(mouseStartX,mouseStartY,width,width);
                gc.fillOval(mouseStartX,mouseStartY,width,width);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval((mouseStartX + width),mouseStartY,(-1 * width),(-1 * width));
                gc.fillOval((mouseStartX + width),mouseStartY,(-1 * width),(-1 * width));
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval(mouseStartX,(mouseStartY+height),width,width);
                gc.fillOval(mouseStartX,(mouseStartY+height),width,width);
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * width));
                gc.fillOval((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * width));
            }
        }
        if (pencil){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        }
        if (eraser){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(event.getX(), event.getY(), 15,15);
        }
        if (ellipse){
            width = event.getX() - mouseStartX;
            height = event.getY() - mouseStartY;
            if (width > 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval(mouseStartX,mouseStartY,width,height);
                gc.fillOval(mouseStartX,mouseStartY,width,height);
            }
            if (width < 0 && height > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval((mouseStartX + width),mouseStartY,(-1 * width),height);
                gc.fillOval((mouseStartX + width),mouseStartY,(-1 * width),height);
            }
            if (height < 0 && width > 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval(mouseStartX,(mouseStartY+height),width,(-1 * height));
                gc.fillOval(mouseStartX,(mouseStartY+height),width,(-1 * height));
            }
            if (height < 0 && width < 0){
                GraphicsContext gc = cnvMain.getGraphicsContext2D();
                gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
                gc.drawImage(snapshot,0,0);
                gc.strokeOval((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
                gc.fillOval((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
            }
        }

    }

    @FXML
    void cnvMainOnMousePressed(MouseEvent event) {
        mouseStartX = event.getX();
        mouseStartY = event.getY();
        snapshot = cnvMain.snapshot(new SnapshotParameters(),null);

        if (pencil){
            cnvMain.getGraphicsContext2D().beginPath();
        }
    }

    @FXML
    void cnvMainOnMouseReleased(MouseEvent event) {
    }

    public void btnDragOnMousePressed(MouseEvent mouseEvent) {
    }

    public void btnDragOnMouseDragged(MouseEvent mouseEvent) {
        tbToolBar.setLayoutX(mouseEvent.getSceneX());
        tbToolBar.setLayoutY(mouseEvent.getSceneY());
    }
}

