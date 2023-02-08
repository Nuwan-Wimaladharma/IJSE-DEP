package lk.ijse.dep10.audioplayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AppInitializer extends Application {
    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene();
    }
    private void mainScene(){
        Stage mainStage = new Stage();
        mainStage.setTitle("Audio Player");
        mainStage.setMinWidth(500);
        mainStage.setMinHeight(500);

        ImageView imgBrowse = new ImageView();
        Image icnBrowse = new Image(this.getClass().getResource("/img/folder.png").toString());
        imgBrowse.setImage(icnBrowse);
        imgBrowse.setFitWidth(50);
        imgBrowse.setFitHeight(50);
        Button btnSelectAudio = new Button("Select Audio");
        btnSelectAudio.setMaxWidth(100);
        btnSelectAudio.setMaxHeight(30);
        btnSelectAudio.setFont(Font.font("Ubuntu",FontWeight.MEDIUM,14));
        HBox hBox1 = new HBox(imgBrowse, btnSelectAudio);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxWidth(200);
        hBox1.setPadding(new Insets(10,10,10,10));

        Label lblStatus = new Label("Select an audio file");
        lblStatus.setFont(Font.font("String", FontWeight.MEDIUM,20));

        ImageView imgPlay = new ImageView();
        Image icnPlay = new Image(this.getClass().getResource("/img/play-button (1).png").toString());
        imgPlay.setImage(icnPlay);
        imgPlay.setFitWidth(40);
        imgPlay.setFitHeight(40);
        ImageView imgPause = new ImageView();
        Image icnPause = new Image(this.getClass().getResource("/img/pause.png").toString());
        imgPause.setImage(icnPause);
        imgPause.setFitWidth(40);
        imgPause.setFitHeight(40);
        ImageView imgStop = new ImageView();
        Image icnStop = new Image(this.getClass().getResource("/img/stop-button.png").toString());
        imgStop.setImage(icnStop);
        imgStop.setFitWidth(40);
        imgStop.setFitHeight(40);
        ImageView imgRepeat = new ImageView();
        Image icnRepeat = new Image(this.getClass().getResource("/img/repeat-once.png").toString());
        imgRepeat.setImage(icnRepeat);
        imgRepeat.setFitWidth(40);
        imgRepeat.setFitHeight(40);
        HBox hBox2 = new HBox(imgPlay,imgPause,imgStop,imgRepeat);
        hBox2.setSpacing(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setMaxWidth(250);
        hBox2.setPadding(new Insets(10,10,10,10));

        ImageView imgVolume = new ImageView();
        Image icnVolume = new Image(this.getClass().getResource("/img/volume-up.png").toString());
        imgVolume.setImage(icnVolume);
        imgVolume.setFitWidth(40);
        imgVolume.setFitHeight(40);
        ImageView imgMute = new ImageView();
        Image icnMute = new Image(this.getClass().getResource("/img/mute.png").toString());
        imgMute.setImage(icnMute);
        imgMute.setFitWidth(40);
        imgMute.setFitHeight(40);
        Slider sldVolumeSlider = new Slider();
        HBox hBox3 = new HBox(imgVolume,sldVolumeSlider);
        hBox3.setSpacing(20);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(10,10,10,10));

        AnchorPane pane1 = new AnchorPane(hBox1);
        pane1.setLayoutX(50);
        pane1.setLayoutY(50);
        pane1.setBackground(Background.fill(Color.LIGHTGRAY));
        AnchorPane pane2 = new AnchorPane(lblStatus);
        pane2.setLayoutX(160);
        pane2.setLayoutY(140);
        pane2.setBackground(Background.fill(Color.LIGHTGREEN));
        AnchorPane pane3 = new AnchorPane(hBox2);
        pane3.setLayoutX(10);
        pane3.setLayoutY(180);
        pane3.setBackground(Background.fill(Color.LIGHTBLUE));
        AnchorPane pane4 = new AnchorPane(hBox3);
        pane4.setLayoutX(270);
        pane4.setLayoutY(180);
        pane4.setBackground(Background.fill(Color.LIGHTPINK));
        AnchorPane root = new AnchorPane(pane1,pane2,pane3,pane4);

        btnSelectAudio.setOnMouseEntered(event -> btnSelectAudio.setScaleX(1.1));
        btnSelectAudio.setOnMouseEntered(event -> btnSelectAudio.setScaleY(1.1));
        btnSelectAudio.setOnMouseExited(event -> btnSelectAudio.setScaleX(1));
        btnSelectAudio.setOnMouseExited(event -> btnSelectAudio.setScaleY(1));
        btnSelectAudio.setOnMousePressed(event -> btnSelectAudio.setEffect(new InnerShadow(10,Color.BLACK)));
        btnSelectAudio.setOnMouseReleased(event -> btnSelectAudio.setEffect(null));
        btnSelectAudio.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open an audio file");
            File audioFile = fileChooser.showOpenDialog(null);
            if (audioFile != null){
                Media media = new Media(audioFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
            }
            else {
                mediaPlayer = null;
            }
        });

        imgPlay.setOnMouseEntered(event -> imgPlay.setOpacity(0.8));
        imgPlay.setOnMouseExited(event -> imgPlay.setOpacity(1));
        imgPlay.setOnMousePressed(event -> imgPlay.setEffect(new InnerShadow(10, Color.BLACK)));
        imgPlay.setOnMouseReleased(event -> {
            imgPlay.setEffect(null);
            if (mediaPlayer != null){
                mediaPlayer.play();
                lblStatus.setText("AUDIO PLAYING");
            }
        });

        imgPause.setOnMouseEntered(event -> imgPause.setOpacity(0.8));
        imgPause.setOnMouseExited(event -> imgPause.setOpacity(1));
        imgPause.setOnMousePressed(event -> imgPause.setEffect(new InnerShadow(10, Color.BLACK)));
        imgPause.setOnMouseReleased(event -> {
            imgPause.setEffect(null);
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                mediaPlayer.pause();
                lblStatus.setText("AUDIO PAUSED");
            }
        });

        imgStop.setOnMouseEntered(event -> imgStop.setOpacity(0.8));
        imgStop.setOnMouseExited(event -> imgStop.setOpacity(1));
        imgStop.setOnMousePressed(event -> imgStop.setEffect(new InnerShadow(10, Color.BLACK)));
        imgStop.setOnMouseReleased(event -> {
            imgStop.setEffect(null);
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                mediaPlayer.stop();
                lblStatus.setText("AUDIO STOPPED");
            }
        });

        imgRepeat.setOnMouseEntered(event -> imgRepeat.setOpacity(0.8));
        imgRepeat.setOnMouseExited(event -> imgRepeat.setOpacity(1));
        imgRepeat.setOnMousePressed(event -> imgRepeat.setEffect(new InnerShadow(10, Color.BLACK)));
        imgRepeat.setOnMouseReleased(event -> {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            lblStatus.setText("AUDIO REPEATING");
        });
        imgVolume.setOnMouseClicked(event -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                imgVolume.setImage(icnMute);
                mediaPlayer.setVolume(0);
                mediaPlayer.pause();
                lblStatus.setText("AUDIO MUTED");
            }
            else {
                imgVolume.setImage(icnVolume);
                mediaPlayer.setVolume(0.5);
                mediaPlayer.play();
                lblStatus.setText("AUDIO PLAYING");
            }
        });

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
        mainStage.show();
    }
}
