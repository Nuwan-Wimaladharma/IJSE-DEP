package lk.ijse.dep10.audioplayer;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
    static double volume;

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
        mainStage.setWidth(500);
        mainStage.setHeight(550);
        mainStage.setResizable(false);

        ImageView imgBrowse = new ImageView();
        Image icnBrowse = new Image(this.getClass().getResource("/img/music-note.png").toString());
        imgBrowse.setImage(icnBrowse);
        imgBrowse.setFitWidth(90);
        imgBrowse.setFitHeight(90);
        HBox hBox1 = new HBox(imgBrowse);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxWidth(200);
        hBox1.setPadding(new Insets(10,10,10,10));

        Label lblSelectedFile = new Label("Select an audio file");
        lblSelectedFile.setFont(Font.font("Ubuntu",FontWeight.MEDIUM,18));
        lblSelectedFile.setBackground(Background.fill(Color.WHITE));
        lblSelectedFile.setPadding(new Insets(12));
        lblSelectedFile.setMaxWidth(Double.MAX_VALUE);
        lblSelectedFile.setAlignment(Pos.CENTER);
        lblSelectedFile.setBorder(Border.stroke(Color.BLACK));
        Label lblStatus = new Label("");
        lblStatus.setFont(Font.font("String", FontWeight.MEDIUM,20));
        lblStatus.setBackground(Background.fill(Color.LIGHTYELLOW));
        lblStatus.setPadding(new Insets(12));
        lblStatus.setMaxWidth(Double.MAX_VALUE);
        lblStatus.setAlignment(Pos.CENTER);

        ImageView imgPlay = new ImageView();
        Image icnPlay = new Image(this.getClass().getResource("/img/play-button (1).png").toString());
        imgPlay.setImage(icnPlay);
        imgPlay.setFitWidth(70);
        imgPlay.setFitHeight(70);
        ImageView imgPause = new ImageView();
        Image icnPause = new Image(this.getClass().getResource("/img/pause.png").toString());
        imgPause.setImage(icnPause);
        imgPause.setFitWidth(70);
        imgPause.setFitHeight(70);
        ImageView imgStop = new ImageView();
        Image icnStop = new Image(this.getClass().getResource("/img/stop-button.png").toString());
        imgStop.setImage(icnStop);
        imgStop.setFitWidth(70);
        imgStop.setFitHeight(70);
        ImageView imgRepeat = new ImageView();
        Image icnRepeat = new Image(this.getClass().getResource("/img/repeat-once.png").toString());
        imgRepeat.setImage(icnRepeat);
        imgRepeat.setFitWidth(70);
        imgRepeat.setFitHeight(70);
        HBox hBox2 = new HBox(imgPlay,imgPause,imgStop,imgRepeat);
        hBox2.setSpacing(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setMaxWidth(250);
        hBox2.setPadding(new Insets(10,10,10,10));

        ImageView imgVolume = new ImageView();
        Image icnVolume = new Image(this.getClass().getResource("/img/volume-up.png").toString());
        imgVolume.setImage(icnVolume);
        imgVolume.setFitWidth(70);
        imgVolume.setFitHeight(70);
        ImageView imgMute = new ImageView();
        Image icnMute = new Image(this.getClass().getResource("/img/mute.png").toString());
        imgMute.setImage(icnMute);
        imgMute.setFitWidth(70);
        imgMute.setFitHeight(70);
        Slider sldVolumeSlider = new Slider(0,1,0.5);
        HBox hBox3 = new HBox(imgVolume,sldVolumeSlider);
        hBox3.setSpacing(20);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(10,10,10,10));

        VBox root = new VBox(hBox1,lblSelectedFile,lblStatus,hBox2,hBox3);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(25);
        root.setPadding(new Insets(20));
        root.setBackground(Background.fill(Color.LIGHTYELLOW));

        imgBrowse.setOnMouseEntered(event -> imgBrowse.setScaleX(1.1));
        imgBrowse.setOnMouseEntered(event -> imgBrowse.setScaleY(1.1));
        imgBrowse.setOnMouseExited(event -> imgBrowse.setScaleX(1));
        imgBrowse.setOnMouseExited(event -> imgBrowse.setScaleY(1));
        imgBrowse.setOnMousePressed(event -> imgBrowse.setEffect(new InnerShadow(10,Color.BLACK)));
        imgBrowse.setOnMouseReleased(event -> imgBrowse.setEffect(null));
        imgBrowse.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open an audio file");
            File audioFile = fileChooser.showOpenDialog(null);
            if (audioFile != null){
                Media media = new Media(audioFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                lblSelectedFile.setText(audioFile + "");
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
                volume = mediaPlayer.getVolume();
                imgVolume.setImage(icnMute);
                mediaPlayer.setVolume(0);
                mediaPlayer.pause();
                lblStatus.setText("AUDIO MUTED");
            }
            else {
                imgVolume.setImage(icnVolume);
                mediaPlayer.setVolume(volume);
                mediaPlayer.play();
                lblStatus.setText("AUDIO PLAYING");
            }
        });

        sldVolumeSlider.valueProperty().addListener((observableValue, t1, t2) -> {
            mediaPlayer.setVolume(sldVolumeSlider.getValue());
            if (sldVolumeSlider.getValue() == 0){
                imgVolume.setImage(icnMute);
                lblStatus.setText("AUDIO MUTED");
            }
            if (sldVolumeSlider.getValue() > 0){
                imgVolume.setImage(icnVolume);
                lblStatus.setText("AUDIO PLAYING");
            }
        });

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
        mainStage.show();
    }
}
