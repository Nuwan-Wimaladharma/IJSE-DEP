package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class MainFormController {

    public ColorPicker clrStroke;
    public ColorPicker clrFill;
    @FXML
    private Canvas cnvMain;
    public AnchorPane root;

    public void initialize(){
//        cnvMain.widthProperty().bind(root.widthProperty());
//        cnvMain.heightProperty().bind(root.heightProperty());
//
//        cnvMain.getGraphicsContext2D().setStroke(clrStroke.getValue());
//        cnvMain.getGraphicsContext2D().setFill(clrFill.getValue());

//        GraphicsContext gc = cnvMain.getGraphicsContext2D();
//
//        gc.setFill(Color.RED);
//        gc.fillRect(50,50,150,150); //starting location(x,y), width, height
//
//        gc.setStroke(Color.RED);
//        gc.strokeRect(50,250,150,150);
//
//        gc.setFill(Color.BLUE);
//        gc.fillRoundRect(250,50,150,150,20,20); //starting location(x,y), width, height, x radius, y radius
//
//        gc.setStroke(Color.BLUE);
//        gc.strokeRoundRect(250,250,150,150,20,20);
//
//        gc.setFont(new Font(32));
//        gc.setFill(Color.GREEN);
//        gc.fillText("IJSE",430,40);
//
//        gc.setStroke(Color.PINK);
//        gc.strokeText("Nuwan",430,90);
//
//        gc.setFill(Color.ORANGE);
//        gc.fillOval(450,200,150,90);
    }

    private double mouseStartX;
    private double mouseStartY;
    private double width;
    private double height;
    private WritableImage snapshot;

    public void cvnMainOnMouseDragged(MouseEvent mouseEvent) {
        width = mouseEvent.getX() - mouseStartX;
        height = mouseEvent.getY() - mouseStartY;
        if (width > 0 && height > 0){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
            gc.drawImage(snapshot,0,0);
            //gc.fillRect(mouseStartX,mouseStartY,width,height);
            gc.strokeRect(mouseStartX,mouseStartY,width,height);
        }
        if (width < 0 && height > 0){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
            //gc.fillRect((mouseStartX + width),mouseStartY,(-1 * width),height);
            gc.strokeRect((mouseStartX + width),mouseStartY,(-1 * width),height);
        }
        if (height < 0 && width > 0){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
            //gc.fillRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
            gc.strokeRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
        }
        if (height < 0 && width < 0){
            GraphicsContext gc = cnvMain.getGraphicsContext2D();
            gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
            //gc.fillRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
            gc.strokeRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
        }

    }

    public void cnvMainOnMousePressed(MouseEvent mouseEvent) {
        mouseStartX = mouseEvent.getX();
        mouseStartY = mouseEvent.getY();
        snapshot = cnvMain.snapshot(new SnapshotParameters(),null);


    }

    public void cnvMainOnMouseReleased(MouseEvent mouseEvent) {
//        width = mouseEvent.getX() - mouseStartX;
//        height = mouseEvent.getY() - mouseStartY;
//        if (width > 0 && height > 0){
//            GraphicsContext gc = cnvMain.getGraphicsContext2D();
//            gc.drawImage(snapshot,0,0);
//            //gc.fillRect(mouseStartX,mouseStartY,width,height);
//            gc.strokeRect(mouseStartX,mouseStartY,width,height);
//        }
//        if (width < 0 && height > 0){
//            GraphicsContext gc = cnvMain.getGraphicsContext2D();
//            //gc.fillRect((mouseStartX + width),mouseStartY,(-1 * width),height);
//            gc.strokeRect((mouseStartX + width),mouseStartY,(-1 * width),height);
//        }
//        if (height < 0 && width > 0){
//            GraphicsContext gc = cnvMain.getGraphicsContext2D();
//            //gc.fillRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
//            gc.strokeRect(mouseStartX,(mouseStartY+height),width,(-1 * height));
//        }
//        if (height < 0 && width < 0){
//            GraphicsContext gc = cnvMain.getGraphicsContext2D();
//            //gc.fillRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
//            gc.strokeRect((mouseStartX + width),(mouseStartY + height),(-1 * width),(-1 * height));
//        }
    }
    public void clrFillOnAction(ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(clrFill.getValue());
    }
    public void clrStrokeOnAction(ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setStroke(clrStroke.getValue());
    }
}

