package lk.ijse.dep10.animations;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppInitializer extends Application {
    Stage transitionStage;
    Stage animationStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.show();
    }
    private void mainScene(Stage stage){
        stage.setTitle("JavaFX Animations Demo");
        stage.setMinWidth(500);
        stage.setMinHeight(400);
        Label lblTitle = new Label("JavaFX Animations Module");
        lblTitle.setTextFill(Color.DARKBLUE);
        lblTitle.setFont(Font.font("Ubuntu",35));
        Button btnTransition = new Button("Transitions");
        btnTransition.setMaxWidth(Double.MAX_VALUE);
        btnTransition.setOnAction(event -> {
            transitionScene();
        });
        Button btnAnimation = new Button("Animations");
        btnAnimation.setMaxWidth(Double.MAX_VALUE);
        btnAnimation.setOnAction(event -> {
            animationScene();
        });
        Label lblTime = new Label(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        KeyFrame key1 = new KeyFrame(Duration.seconds(1), event -> {
            lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        });
        Timeline timeline = new Timeline(key1);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        lblTime.setFont(new Font(18));
        lblTime.setMaxWidth(Double.MAX_VALUE);
        lblTime.setAlignment(Pos.CENTER);

        VBox container = new VBox(lblTitle,btnTransition,btnAnimation,lblTime);
        container.setSpacing(20);
        container.setPadding(new Insets(20));
        container.setAlignment(Pos.CENTER);

        Scene firstScene = new Scene(container);
        stage.setScene(firstScene);
        stage.centerOnScreen();
    }
    private void transitionScene(){
        if (transitionStage != null) return;
        transitionStage = new Stage();
        transitionStage.setOnCloseRequest(event -> {
            transitionStage = null;
        });
        transitionStage.setTitle("Transitions");
        transitionStage.setMinWidth(800);
        transitionStage.setMinHeight(400);

        Button btnReset = new Button("Reset");
        Button btnFadeIn = new Button("Fade In");
        Button btnFadeOut = new Button("Fade Out");
        Button btnScale = new Button("Scale");
        Button btnRotate = new Button("Rotate");
        Button btnTranslateX = new Button("TranslateX");
        Button btnTranslateY = new Button("TranslateY");

        HBox hBox = new HBox(btnReset,btnFadeIn,btnFadeOut,btnScale,btnRotate,btnTranslateX,btnTranslateY);
        Label lblPreview = new Label("PREVIEW");

        VBox root = new VBox(hBox,lblPreview);
        root.setMinWidth(800);
        root.setMinHeight(400);
        root.setPadding(new Insets(10));
        root.setSpacing(150);
        root.setBackground(Background.fill(Color.WHITE));

        hBox.setSpacing(10);
        Font font = new Font(16);
        for (Node child : hBox.getChildren()) {
            Button btn = (Button) child;
            btn.setFont(font);
            btn.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(btn, Priority.ALWAYS);
        }
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);
        lblPreview.setFont(new Font(44));
        lblPreview.setTextFill(Color.LIGHTGRAY);

        Scene scene = new Scene(root);
        transitionStage.setScene(scene);
        //transitionStage.centerOnScreen();
        transitionStage.show();

        btnFadeIn.setOnAction(event -> {
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(5),lblPreview);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        });
        btnFadeOut.setOnAction(event -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(5),lblPreview);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.play();
        });
        btnScale.setOnAction(event -> {
            ScaleTransition scale = new ScaleTransition(Duration.seconds(5),lblPreview);
            scale.setFromX(1);
            scale.setToY(1);
            scale.setToX(2);
            scale.setToY(2);
            scale.play();
        });
        btnRotate.setOnAction(event -> {
            RotateTransition rotate = new RotateTransition(Duration.seconds(1),lblPreview);
            rotate.setFromAngle(0);
            rotate.setToAngle(180);
            rotate.play();
        });
        btnTranslateX.setOnAction(event -> {
            TranslateTransition translateX = new TranslateTransition(Duration.seconds(2),lblPreview);
            translateX.setFromX(-500);
            translateX.setToX(0);
            translateX.play();
        });
        btnTranslateY.setOnAction(event -> {
            TranslateTransition translateY = new TranslateTransition(Duration.seconds(2),lblPreview);
            translateY.setFromY(500);
            translateY.setToY(0);
            translateY.play();
        });
        btnReset.setOnAction(event -> {
            lblPreview.setScaleX(1);
            lblPreview.setScaleY(1);
            lblPreview.setRotate(0);
            lblPreview.setOpacity(1);
        });
    }
    private void animationScene(){
        if (animationStage != null) return;
        animationStage = new Stage();
        animationStage.setOnCloseRequest(event -> {
            animationStage = null;
        });
        animationStage.setTitle("Animations");
        animationStage.setMinWidth(400);
        animationStage.setMinHeight(400);

        Button btnPlay = new Button("Play");
        btnPlay.setFont(Font.font("Ubuntu",20));
        Button btnStop = new Button("Stop");
        btnStop.setFont(Font.font("Ubuntu",20));
        Label lblPreview = new Label("PREVIEW");
        lblPreview.setFont(Font.font("Ubuntu",35));
        lblPreview.setBackground(Background.fill(Color.LIGHTGRAY));
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setMaxHeight(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(btnPlay, btnStop);
        vBox.setSpacing(20);

        HBox root = new HBox(vBox,lblPreview);
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        HBox.setHgrow(lblPreview,Priority.ALWAYS);

        Scene scene = new Scene(root);
        animationStage.setScene(scene);
        animationStage.centerOnScreen();
        animationStage.show();


        //animationStage.centerOnScreen();
        animationStage.show();

        KeyFrame key1 = new KeyFrame(Duration.millis(500), event -> {
            lblPreview.setTextFill(Color.RED);
        });
        KeyFrame key2 = new KeyFrame(Duration.millis(750), event -> {
            lblPreview.setScaleX(1.5);
            lblPreview.setScaleY(1.5);
        });
        KeyFrame key3 = new KeyFrame(Duration.millis(1250), event -> {
            lblPreview.setTextFill(Color.GREEN);
            lblPreview.setScaleX(1);
            lblPreview.setScaleY(1);
        });
        KeyFrame key4 = new KeyFrame(Duration.millis(1800), event -> {
            lblPreview.setTranslateX(50);
        });
        KeyFrame key5 = new KeyFrame(Duration.millis(1900), event -> {
            lblPreview.setTextFill(Color.BLUE);
        });

        Timeline timeLine = new Timeline(key1,key2,key3,key4,key5);
        timeLine.setCycleCount(Animation.INDEFINITE);

        btnPlay.setOnAction(event -> {
            timeLine.playFromStart();
        });
        btnStop.setOnAction(event -> {
            timeLine.stop();
        });
    }
}
