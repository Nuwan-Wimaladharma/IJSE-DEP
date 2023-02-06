package lk.ijse.dep10.scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("JVM is about to shutdown");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scene Manipulation");
        primaryStage.show();
        primaryStage.setMinWidth(250);
        primaryStage.setMaxWidth(750);
        primaryStage.centerOnScreen();
        mainScene(primaryStage);
    }
    private void mainScene(Stage stage){
        Label lblTitle = new Label("Main Scene");
        lblTitle.setBackground(Background.fill(Color.web("black",1)));
        lblTitle.setTextFill(Color.web("white",1));
        Font fontForTitle = new Font("Ubuntu",20);
        lblTitle.setFont(fontForTitle);
        Font fontForButtons = new Font("Ubuntu", 20);
        Button btn1 = new Button("Scene 1");
        //btn1.setFont(fontForButtons);
        Button btn2 = new Button("Scene 2");
        //btn2.setFont(fontForButtons);
        Button btn3 = new Button("Scene 3");
        //btn3.setFont(fontForButtons);
        Button btn4 = new Button("Platform Exit");
        //btn4.setFont(fontForButtons);
        Paint paintForBtn4 = new Color(1,0,0,0.6); //R/255,G/255,B/255,Opacity or Color,rgb(255,0,0,1) can be used or Color.web("red")
        Background backgroundForBtn4 = Background.fill(paintForBtn4);
        btn4.setBackground(backgroundForBtn4);
        Button btn5 = new Button("System Exit");
        btn5.setBackground(Background.fill(Color.color(0.7,0.2,0.8,0.5)));
        //btn5.setFont(fontForButtons);
        //btn1.setMaxWidth(Double.MAX_VALUE); //this helps to automatic resizing of the button

        btn1.setOnAction(event -> {
            firstScene(stage);
        });
        btn2.setOnAction(event -> {
            secondScene(stage);
        });
        btn3.setOnAction(event -> {
            thirdScene(stage);
        });
        btn4.setOnAction(event -> {
            System.out.println("Platform Exit");
            Platform.exit();
        });
        btn5.setOnAction(event -> {
            System.out.println("System Exit");
            System.exit(0);
        });

        VBox root = new VBox(lblTitle,btn1,btn2,btn3,btn4,btn5);
        root.setPrefWidth(400);
        root.setBackground(Background.fill(Color.web("orange",0.5)));
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        for (Node child : root.getChildren()) { //every javafx controller is a Node
            if (!(child instanceof Labeled)) continue;
            Labeled lbl = (Labeled) child;
            lbl.setFont(fontForButtons);
            ((Labeled) child).setMaxWidth(Double.MAX_VALUE);

//            if (child instanceof Button){                                  //this black is similar to the above block
//                ((Button) child).setFont(fontForButtons);
//            }
//            else if (child instanceof Label){
//                ((Label) child).setFont(fontForButtons);
//            }
        }
        lblTitle.setAlignment(Pos.CENTER);

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
    private void firstScene(Stage stage){
        Label titleOfTheFirstScene = new Label("First Scene");
        titleOfTheFirstScene.setBackground(Background.fill(Color.web("black",1)));
        titleOfTheFirstScene.setTextFill(Color.web("white",1));
        titleOfTheFirstScene.setMaxWidth(Double.MAX_VALUE);

        Button backButton = new Button("BACK");
        backButton.setMaxWidth(Double.MAX_VALUE);
        backButton.setOnAction(event -> {
            mainScene(stage);
        });

        VBox firstSceneContainer = new VBox(titleOfTheFirstScene,backButton);
        firstSceneContainer.setBackground(Background.fill(Color.color(0.6,0.9,0.8,0.5)));
        firstSceneContainer.setSpacing(10);
        firstSceneContainer.setAlignment(Pos.CENTER);
        firstSceneContainer.setPrefWidth(400);
        firstSceneContainer.setPrefHeight(400);
        firstSceneContainer.setPadding(new Insets(10));

        Scene firstScene = new Scene(firstSceneContainer);
        stage.setScene(firstScene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
    private void secondScene(Stage stage){
        System.out.println("Second Scene");
    }
    private void thirdScene(Stage stage){
        System.out.println("Third Scene");
    }

}
