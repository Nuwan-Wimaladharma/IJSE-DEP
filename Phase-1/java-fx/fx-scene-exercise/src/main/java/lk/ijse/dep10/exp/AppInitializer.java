package lk.ijse.dep10.exp;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class AppInitializer extends Application {
    static KeyFrame key;
    static int a;
    static int b;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene();
        //tempScene(primaryStage);
        //primaryStage.show();
    }
    private void tempScene(Stage stage){
        Button btn = new Button("Click me");
        AnchorPane root = new AnchorPane(btn);
        AnchorPane.setLeftAnchor(btn,10.0);
        AnchorPane.setRightAnchor(btn,10.0);
        Scene tempScene = new Scene(root);
        stage.setScene(tempScene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.centerOnScreen();
    }
    private void loginScene(){
        Stage loginStage = new Stage();
        loginStage.setTitle("LOGIN");
        loginStage.setWidth(400);
        loginStage.setHeight(400);

        Label loginLabel = new Label("LOGIN");
        loginLabel.setFont(Font.font("Ubuntu",35));
        loginLabel.setTextFill(Color.DARKBLUE);
        loginLabel.setPadding(new Insets(25,0,0,0));

        Label enterPassword = new Label("Enter Password");

        PasswordField password = new PasswordField();
        password.setMaxWidth(300);
        password.setAlignment(Pos.CENTER);

        Label hintLabel = new Label("Invalid Password, Try Again!");
        hintLabel.setTextFill(Color.RED);
        hintLabel.setVisible(false);


        Button logInButton = new Button("LOGIN");
        logInButton.setDefaultButton(true);

        VBox loginSceneContainer = new VBox(loginLabel, enterPassword, password, hintLabel, logInButton);
        loginSceneContainer.setSpacing(20);
        loginSceneContainer.setAlignment(Pos.CENTER);

        Scene logInScene = new Scene(loginSceneContainer);
        loginStage.setScene(logInScene);
        loginStage.show();
        loginStage.centerOnScreen();

        logInButton.setOnAction(event -> {
            String passwordString = password.getText();
            if (!passwordString.equals("Admin")){
                hintLabel.setVisible(true);
                password.selectAll();
            }
            else {
                appStage();
            }
        });
    }
    private void appStage(){
        Stage appStage = new Stage();
        appStage.setTitle("MY APP");

        Label message = new Label("HI !, WELCOME TO THE APP");
        message.setFont(new Font(32));
        message.setTextFill(new Color(0,0,0,0.4));

//        TranslateTransition transitionMessage = new TranslateTransition(Duration.seconds(1),message);
//        transitionMessage.setFromX(-700);
//        transitionMessage.setToX(50);
//        transitionMessage.play();

        KeyFrame key1 = new KeyFrame(Duration.seconds(0), event -> {
            TranslateTransition transitionMessage1 = new TranslateTransition(Duration.seconds(1),message);
            transitionMessage1.setFromX(-700);
            transitionMessage1.setToX(50);
            transitionMessage1.play();
        });
        KeyFrame key2 = new KeyFrame(Duration.seconds(1), event -> {
            TranslateTransition transitionMessage2 = new TranslateTransition(Duration.seconds(0.2),message);
            transitionMessage2.setFromX(50);
            transitionMessage2.setToX(0);
            transitionMessage2.play();
        });
        KeyFrame key3 = new KeyFrame(Duration.seconds(1.2), event -> {
            ScaleTransition transitionMessage3 = new ScaleTransition(Duration.seconds(0.2),message);
            transitionMessage3.setFromX(1);
            transitionMessage3.setFromY(1);
            transitionMessage3.setToX(1.5);
            transitionMessage3.setToY(1.5);
            transitionMessage3.play();
        });
        KeyFrame key4 = new KeyFrame(Duration.seconds(1.4), event -> {
            ScaleTransition transitionMessage4 = new ScaleTransition(Duration.seconds(0.2),message);
            transitionMessage4.setFromX(1.5);
            transitionMessage4.setFromY(1.5);
            transitionMessage4.setToX(1);
            transitionMessage4.setToY(1);
            transitionMessage4.play();
        });

        Timeline timeLine = new Timeline(key1,key2,key3,key4);
        timeLine.setCycleCount(1);
        timeLine.playFromStart();

        String mainText = "Nuwan Wimaladharma";
        String[] letters = new String[(mainText.length() * 2) - 1];
        for (int i = 0; i < mainText.length(); i++) {
            String temp = "";
            for (int j = 0; j <= i; j++) {
                temp += (mainText.charAt(j));
            }
            letters[i] = temp;
        }
        String[] reverseLetters = new String[mainText.length()-1];
        for (int i = reverseLetters.length-1; i >= 0; i--) {
            String temp = "";
            for (int j = 0; j <= i ; j++) {
                temp += (mainText.charAt(j));
            }
            reverseLetters[reverseLetters.length-1-i] = temp;
        }
        for (int i = mainText.length(); i < (mainText.length()*2)-1; i++) {
            letters[i] = reverseLetters[i - mainText.length()];
        }
        Label lbl = new Label();
        AnchorPane container = new AnchorPane(lbl);

        StackPane movingContainer = new StackPane(message,container);
        movingContainer.setBackground(Background.fill(Color.WHITE));
        movingContainer.setPadding(new Insets(10));
        movingContainer.setPrefHeight(600);
        movingContainer.setPrefWidth(800);

        a = 0;
        b = 0;
        KeyFrame[] keys = new KeyFrame[letters.length];
        for (int i = 0; i < keys.length; i++) {
            keys[b] = new KeyFrame(Duration.millis(++b * 150),event -> {
                lbl.setText(letters[a++]);
                if (a == letters.length) a = 0;
            });
        }
        Timeline timeLine2 = new Timeline(keys);
        timeLine2.setCycleCount(Animation.INDEFINITE);
        timeLine2.playFromStart();

        movingContainer.setOnMouseEntered(event -> lbl.setVisible(true));
        movingContainer.setOnMouseExited(event -> lbl.setVisible(false));
        movingContainer.setOnMouseMoved(event -> {
            lbl.setLayoutX(event.getX() + 10);
            lbl.setLayoutY(event.getY() + 10);
        });

        Scene appScene = new Scene(movingContainer);
        appStage.setScene(appScene);
        appStage.show();
        appStage.centerOnScreen();
    }
}
