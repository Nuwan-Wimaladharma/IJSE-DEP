package lk.ijse.dep10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;

public class AppInitializer extends Application {
    static double x;
    static double y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView imgView = new ImageView();
        Image imgBackGround = new Image(this.getClass().getResource("/img/bg2.png").toString());
        imgView.setImage(imgBackGround);

        Button btnExit = new Button("X");
        btnExit.setFont(Font.font("",20));
        btnExit.setCursor(Cursor.HAND);
        btnExit.setOnMouseEntered(event -> btnExit.setTextFill(Color.RED));
        btnExit.setOnMouseExited(event -> btnExit.setTextFill(Color.BLACK));
        btnExit.setBackground(Background.fill(Color.TRANSPARENT));
        btnExit.setOnAction(actionEvent -> {
            primaryStage.close();
        });

        Button btnMinimize = new Button("--");
        btnMinimize.setFont(Font.font("",20));
        btnMinimize.setCursor(Cursor.HAND);
        btnMinimize.setOnMouseEntered(event -> btnMinimize.setTextFill(Color.RED));
        btnMinimize.setOnMouseExited(event -> btnMinimize.setTextFill(Color.BLACK));
        btnMinimize.setBackground(Background.fill(Color.TRANSPARENT));
        btnMinimize.setOnMouseClicked(event -> {
            primaryStage.setIconified(true);
        });

        Slider slider = new Slider(0,100,30);
        slider.setPrefWidth(300);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);

        slider.valueProperty().addListener((value, previous, current) -> {
            System.out.println(current);
        });
        HBox hBoxSlider = new HBox(slider);
        AnchorPane.setTopAnchor(hBoxSlider,380.0);
        AnchorPane.setLeftAnchor(hBoxSlider,250.0);

        HBox hBox = new HBox(btnMinimize,btnExit);
        AnchorPane.setTopAnchor(hBox,40.0);
        AnchorPane.setRightAnchor(hBox,90.0);

        AnchorPane root = new AnchorPane(imgView,hBox,hBoxSlider);
        imgView.setOpacity(0.5);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        AnchorPane.setTopAnchor(imgView,0.0);
        AnchorPane.setBottomAnchor(imgView,0.0);
        AnchorPane.setLeftAnchor(imgView,0.0);
        AnchorPane.setRightAnchor(imgView,0.0);

        root.setOnMousePressed(event -> {
            x = event.getX();
            y = event.getY();
        });
        root.setOnMouseReleased(event -> {
            root.setCursor(Cursor.DEFAULT);
        });
        root.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);
                root.setCursor(Cursor.MOVE);
            }
        });

        Scene mainScene = new Scene(root);
        mainScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(mainScene);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Undecorated Windows");
        primaryStage.setWidth(800);
        primaryStage.setHeight(890);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
