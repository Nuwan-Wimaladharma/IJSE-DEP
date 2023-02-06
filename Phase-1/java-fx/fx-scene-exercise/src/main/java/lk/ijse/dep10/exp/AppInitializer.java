package lk.ijse.dep10.exp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene();
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

//        Label message = new Label("HI !, WELCOME TO THE APP");
//        message.setFont(new Font(32));
//        message.setTextFill(new Color(0,0,0,0.4));

        Label lbl = new Label("Hi, I'm moving");

        AnchorPane movingContainer = new AnchorPane(lbl);
        movingContainer.setBackground(Background.fill(Color.WHITE));
        movingContainer.setPadding(new Insets(10));
        movingContainer.setPrefHeight(600);
        movingContainer.setPrefWidth(800);

        movingContainer.setOnMouseEntered(event -> lbl.setVisible(true));
        movingContainer.setOnMouseExited(event -> lbl.setVisible(false));
        movingContainer.setOnMouseMoved(event -> {
            lbl.setLayoutX(event.getX() + 10);
            lbl.setLayoutY(event.getY() + 10);
        });

//        VBox appContainer = new VBox(message);
//        appContainer.setPrefHeight(600);
//        appContainer.setPrefWidth(800);
//        appContainer.setAlignment(Pos.CENTER);
//        appContainer.setPadding(new Insets(20));

        Scene appScene = new Scene(movingContainer);
        appStage.setScene(appScene);
        appStage.show();
        appStage.centerOnScreen();
    }
}
