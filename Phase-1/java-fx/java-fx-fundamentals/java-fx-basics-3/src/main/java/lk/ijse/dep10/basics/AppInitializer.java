package lk.ijse.dep10.basics;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class AppInitializer extends Application {

    private static Stage stgProgressBar;
    private static Stage stgImageViewer;
    private static Stage stgAudioPlayer;
    private static Stage stgVideoPlayer;
    private  static Stage stgDialogs;
    private MediaPlayer mediaPlayer;
    private SimpleBooleanProperty isMute = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.setTitle("Java FX Controls Continue");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void mainScene(Stage stage) {
        Label lblTitle = new Label("Java FX Controls Cont.");
        Button btnProgressBar = new Button("Progress Bar");
        Button btnImageViewer = new Button("Image Viewer");
        Button btnAudio = new Button("Play Audio");
        Button btnVideo = new Button("Play Video");
        Button btnDialogs = new Button("FX Dialogs");
        VBox root = new VBox(lblTitle, btnProgressBar, btnImageViewer, btnAudio, btnVideo, btnDialogs);

        root.setSpacing(10);
        root.setPadding(new Insets(10));

        lblTitle.setFont(new Font(20));
        lblTitle.setMaxWidth(Double.MAX_VALUE);
        lblTitle.setAlignment(Pos.CENTER);

        Font font = new Font(16);
        btnProgressBar.setFont(font);
        btnImageViewer.setFont(font);
        btnAudio.setFont(font);
        btnVideo.setFont(font);
        btnDialogs.setFont(font);
        btnProgressBar.setMaxWidth(Double.MAX_VALUE);
        btnImageViewer.setMaxWidth(Double.MAX_VALUE);
        btnAudio.setMaxWidth(Double.MAX_VALUE);
        btnVideo.setMaxWidth(Double.MAX_VALUE);
        btnDialogs.setMaxWidth(Double.MAX_VALUE);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(400);

        /* Setting Event Listeners */

        btnProgressBar.setOnAction(event -> showProgressBarStage());
        btnImageViewer.setOnAction(event -> showImageViewerStage());
        btnAudio.setOnAction(event -> showAudioPlayerStage());
        btnVideo.setOnAction(event -> showVideoPlayerStage());
        btnDialogs.setOnAction(event -> showDialogStage());
    }

    private void showProgressBarStage() {
        if (stgProgressBar != null) return;

        stgProgressBar = new Stage();
        stgProgressBar.setTitle("Progress Bar Demo");
        progressBarScene();
        stgProgressBar.show();
        stgProgressBar.centerOnScreen();

        /* Setting Event Listeners */

        stgProgressBar.setOnCloseRequest(event -> stgProgressBar = null);
    }

    private void progressBarScene() {
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        HBox hBox = new HBox(btnStart, btnStop);

        ProgressBar prg = new ProgressBar(0);
        Label lblPercentage = new Label("0%");
        VBox root = new VBox(hBox, prg, lblPercentage);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Font font = new Font(16);
        btnStart.setFont(font);
        btnStop.setFont(font);

        lblPercentage.setFont(font);

        prg.setMaxWidth(Double.MAX_VALUE);

        stgProgressBar.setScene(new Scene(root));
        stgProgressBar.setMinWidth(300);
        stgProgressBar.setWidth(600);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(50), event -> {
            prg.setProgress(prg.getProgress() + 0.05);
            int percentage = (int) (prg.getProgress() * 100);
            if (percentage < 100) lblPercentage.setText(percentage + "%");
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        /* Setting Event Listeners */

        prg.progressProperty().addListener((value, previousValue, currentValue) -> {
            System.out.printf("Old-Value: %s, New Value: %s \n", previousValue, currentValue);
            if (currentValue.intValue() >= 1) {
                timeline.stop();
                lblPercentage.setText("Completed!");
            }
        });

        btnStart.setOnAction(event -> {
            if (prg.getProgress() >= 1) prg.setProgress(0);
            timeline.playFromStart();
        });
        btnStop.setOnAction(event -> timeline.stop());
    }

    private void showImageViewerStage() {
        if (stgImageViewer != null) return;

        stgImageViewer = new Stage();
        stgImageViewer.setTitle("Image Viewer Demo");
        imageViewerScene();
        stgImageViewer.show();
        stgImageViewer.centerOnScreen();

        /* Setting Event Listeners */

        stgImageViewer.setOnCloseRequest(event -> stgImageViewer = null);
    }

    private void imageViewerScene() {
        ImageView img1 = new ImageView();
        AnchorPane pne1 = new AnchorPane(img1);
        AnchorPane.setLeftAnchor(img1, 0.0);
        AnchorPane.setTopAnchor(img1, 0.0);
        AnchorPane.setRightAnchor(img1, 0.0);
        AnchorPane.setBottomAnchor(img1, 0.0);

        ImageView img2 = new ImageView();
        AnchorPane pne2 = new AnchorPane(img2);
        AnchorPane.setLeftAnchor(img2, 0.0);
        AnchorPane.setTopAnchor(img2, 0.0);
        AnchorPane.setRightAnchor(img2, 0.0);
        AnchorPane.setBottomAnchor(img2, 0.0);

        Button btnInternalResource = new Button("Internal Resource");
        Button btnExternalResource = new Button("External Resource");
        VBox vBox1 = new VBox(pne1, btnInternalResource);
        VBox vBox2 = new VBox(pne2, btnExternalResource);
        HBox root = new HBox(vBox1, vBox2);

        pne1.setPrefWidth(250);
        pne1.setPrefHeight(250);
        pne2.setPrefWidth(250);
        pne2.setPrefHeight(250);

        pne1.setBorder(Border.stroke(Color.GRAY));
        pne2.setBorder(Border.stroke(Color.GRAY));

        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox1.setSpacing(15);
        vBox2.setSpacing(15);

        Font font = new Font(16);
        btnInternalResource.setFont(font);
        btnExternalResource.setFont(font);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(10));

        stgImageViewer.setScene(new Scene(root));
        stgImageViewer.setWidth(600);
        stgImageViewer.setMinHeight(400);

        /* Setting Event Listeners */

        btnInternalResource.setOnAction(event -> {
//            AppInitializer.class.getResource():URL    // Within static context
//            this.getClass().getResource():URL

//            Image image = new Image("/img/background-image.png"); // Java FX Only

            Image image = new Image(this.getClass().getResource("/img/background-image.png").toString());
            img1.setImage(image);
            img1.setFitWidth(250);
            img1.setFitHeight(250);
        });

        btnExternalResource.setOnAction(event -> {
            // File (Old)
            // Path (New)

//            Image image = new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
//            Image image = new Image("file:data/img/background-image.jpg"); // Java FX Only

//            Image image = new Image(new File("data/img/background-image.jpg").toURI().toString());
            Image image = new Image(Path.of("data/img/background-image.jpg").toUri().toString());
//            Image image = new Image(Path.of("/home/ranjith-suranga/Desktop/transient.jpg").toUri().toString());
            img2.setImage(image);
            img2.setFitWidth(250);
            img2.setFitHeight(250);
        });
    }

    private void showAudioPlayerStage(){
        if (stgAudioPlayer != null) return;

        stgAudioPlayer = new Stage();
        stgAudioPlayer.setTitle("Audio Player Demo");
        audioPlayerScene();
        stgAudioPlayer.show();
        stgAudioPlayer.centerOnScreen();

        /* Setting Event Listeners */

        stgAudioPlayer.setOnCloseRequest(event -> stgAudioPlayer = null);
    }

    private void audioPlayerScene(){
        Button btnOpen = new Button("Open a File");
        ImageView img = new ImageView();
        Label lblStatus = new Label("Click to play the audio");
        VBox root = new VBox(btnOpen, img, lblStatus);

        Image icnPlay = new Image(this.getClass().getResource("/img/play-button.png").toString());
        Image icnStop = new Image(this.getClass().getResource("/img/stop.png").toString());

        img.setImage(icnPlay);

        img.setFitWidth(150);
        img.setFitHeight(150);
        img.setCursor(Cursor.HAND);

        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);

        lblStatus.setFont(new Font(24));

        stgAudioPlayer.setScene(new Scene(root));
        stgAudioPlayer.setMinWidth(400);
        stgAudioPlayer.setWidth(400);
        stgAudioPlayer.setMinHeight(400);

//        Media media = new Media(new File("data/mp3/The Java Life.mp3").toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(null);

        /* Setting Event Listeners */

        img.setOnMouseEntered(event -> img.setOpacity(0.8));
        img.setOnMouseExited(event -> img.setOpacity(1));
        img.setOnMousePressed(event -> img.setEffect(new InnerShadow(10, Color.BLACK)));
        img.setOnMouseReleased(event -> {
            img.setEffect(null);

            if (mediaPlayer != null) {
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    lblStatus.setText("Stopped!");
                    img.setImage(icnPlay);
                    mediaPlayer.stop();
                } else {
                    lblStatus.setText("Playing...");
                    img.setImage(icnStop);
                    mediaPlayer.play();
                }
            }
        });

        btnOpen.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle("Open an audio file");
            File audioFile = fileChooser.showOpenDialog(null);

            if (audioFile != null){
                Media media = new Media(audioFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);

//                setMute, isMute
//                setVolume, getVolum
//                pause
//                setCycleCount
            }else{
                mediaPlayer = null;
            }
        });
    }

    private void showVideoPlayerStage(){
        if (stgVideoPlayer != null) return;

        stgVideoPlayer = new Stage();
        stgVideoPlayer.setTitle("Video Player Demo");
        videoPlayerScene();
        stgVideoPlayer.show();
        stgVideoPlayer.centerOnScreen();


        //stgVideoPlayer.setOnCloseRequest(event -> stgVideoPlayer = null);
    }
    private void videoPlayerScene(){
        ImageView imgPlay = new ImageView();
        Image icnPlay = new Image(this.getClass().getResource("/img/play-button (1).png").toString());
        imgPlay.setImage(icnPlay);
        imgPlay.setFitHeight(80);
        imgPlay.setFitWidth(80);

        ImageView imgPause = new ImageView();
        Image icnPause = new Image(this.getClass().getResource("/img/pause.png").toString());
        imgPause.setImage(icnPause);
        imgPause.setFitHeight(80);
        imgPause.setFitWidth(80);

        ImageView imgStop = new ImageView();
        Image icnStop = new Image(this.getClass().getResource("/img/stop-button.png").toString());
        imgStop.setImage(icnStop);
        imgStop.setFitWidth(80);
        imgStop.setFitHeight(80);

        ImageView imgBrowse = new ImageView();
        Image icnBrowse = new Image(this.getClass().getResource("/img/folder.png").toString());
        imgBrowse.setImage(icnBrowse);
        imgBrowse.setFitHeight(80);
        imgBrowse.setFitWidth(80);

        ImageView imgVolume = new ImageView();
        Image icnVolume = new Image(this.getClass().getResource("/img/volume-up.png").toString());
        imgVolume.setImage(icnVolume);
        imgVolume.setFitWidth(80);
        imgVolume.setFitHeight(80);

        ImageView imgMute = new ImageView();
        Image icnMute = new Image(this.getClass().getResource("/img/mute.png").toString());
        imgMute.setImage(icnMute);
        imgMute.setFitWidth(80);
        imgMute.setFitHeight(80);

        Label lblPlay = new Label("",imgPlay);
        Label iblPause = new Label("",imgPause);
        Label lblStop = new Label("", imgStop);
        Label lblBrowse = new Label("",imgBrowse);
        Label lblVolume = new Label("",imgVolume);

        Slider slider = new Slider(0,1,0.5);
        HBox hBox = new HBox(lblPlay,lblStop,lblBrowse,lblVolume,slider);
        hBox.setSpacing(15);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(100);
        hBox.setPrefWidth(800);
        hBox.setBackground(Background.fill(Color.GRAY));
        HBox.setHgrow(lblBrowse,Priority.ALWAYS);
        lblBrowse.setMaxWidth(Double.MAX_VALUE);
        lblBrowse.setAlignment(Pos.CENTER);

        Image imgBackGround = new Image(this.getClass().getResource("/img/play.png").toString());
        ImageView imgViewBackGround = new ImageView(imgBackGround);
        imgViewBackGround.setFitWidth(120);
        imgViewBackGround.setFitHeight(120);
        Label lblBackGround = new Label("",imgViewBackGround);

        MediaView mediaView = new MediaView();
        mediaView.setPreserveRatio(true);
        StackPane stackPane = new StackPane(lblBackGround,mediaView);
        stackPane.setBackground(Background.fill(Color.BLACK));

        AnchorPane root = new AnchorPane(stackPane,hBox);

        AnchorPane.setBottomAnchor(hBox,0.0);
        AnchorPane.setLeftAnchor(hBox,0.0);
        AnchorPane.setRightAnchor(hBox,0.0);

        AnchorPane.setBottomAnchor(stackPane,100.0);
        AnchorPane.setLeftAnchor(stackPane,0.0);
        AnchorPane.setRightAnchor(stackPane,0.0);
        AnchorPane.setTopAnchor(stackPane,0.0);

        stgVideoPlayer.setScene(new Scene(root));
        stgVideoPlayer.setMinWidth(700);
        stgVideoPlayer.setMinHeight(700);
        stgVideoPlayer.setWidth(800);
        stgVideoPlayer.setHeight(800);

        mediaView.fitWidthProperty().bind(stackPane.widthProperty());
        mediaView.fitHeightProperty().bind(stackPane.heightProperty());

        lblBrowse.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files,","*.mp4","*.avi","*.flv"));
            fileChooser.setTitle("Open a video file");
            File videoFile = fileChooser.showOpenDialog(stgVideoPlayer);
            if (videoFile != null){
                Media media = new Media(videoFile.toURI().toString());
                MediaPlayer videoPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(videoPlayer);
                mediaView.toFront();
                videoPlayer.play();
                lblPlay.setGraphic(imgPause);

                videoPlayer.volumeProperty().bind(slider.valueProperty());
                //new SimpleDoubleProperty()
                //new SimpleBooleanProperty()
                //new SimpleStringProperty()
                //new SimpleFloatProperty()
                //new SimpleIntegerProperty()
                //new SimpleLongProperty()  //to convert primitive to observable
                videoPlayer.muteProperty().bind(isMute);
            }
        });
        lblStop.setOnMouseClicked(event -> {
            MediaPlayer videoPlayer = mediaView.getMediaPlayer();
            if (videoPlayer != null){
                videoPlayer.stop();
                mediaView.setMediaPlayer(null);
                lblBackGround.toFront();
                lblPlay.setGraphic(imgPlay);
            }
        });
        lblPlay.setOnMouseClicked(event -> {
            MediaPlayer videoPlayer = mediaView.getMediaPlayer();
            if (videoPlayer == null) return;
            if (videoPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                videoPlayer.pause();
                lblPlay.setGraphic(imgPlay);
            }
            else{
                videoPlayer.play();
                lblPlay.setGraphic(imgPause);
            }
        });
        lblVolume.setOnMouseClicked(event -> {
            isMute.set(!isMute.get());
            if (isMute.get()){
                lblVolume.setGraphic(imgMute);
            }
            else {
                lblVolume.setGraphic(imgVolume);
            }
        });
        stgVideoPlayer.setOnCloseRequest(event -> {
            MediaPlayer videoPlayer = mediaView.getMediaPlayer();
            if (videoPlayer != null) videoPlayer.stop();
            mediaView.setMediaPlayer(null);
            stgVideoPlayer = null;
        });
    }

    private void showDialogStage(){
        if (stgDialogs != null) return;

        stgDialogs = new Stage();
        stgDialogs.setTitle("FX Dialogs");
        dialogScene();
        stgDialogs.show();
        stgDialogs.centerOnScreen();

        /* Setting Event Listeners */

        stgDialogs.setOnCloseRequest(event -> stgDialogs = null);
    }
    private void dialogScene(){
        Button btnErrMsg = new Button("Error Message");
        Button btnWarMsg = new Button("Warning Message");
        Button btnInfoMsg = new Button("Information Message");
        Button btnConfirmationMsg = new Button("Confirmation Message");
        Button btnCustomMsg = new Button("Custom Message");

        VBox root = new VBox(btnErrMsg,btnWarMsg,btnInfoMsg,btnConfirmationMsg,btnCustomMsg);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        for (Node control : root.getChildren()) {
            Button btn = (Button) control;
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setFont(new Font(16));
        }

        Scene scene = new Scene(root);
        stgDialogs.setScene(scene);
        stgDialogs.sizeToScene();
        stgDialogs.setWidth(400);

        btnErrMsg.setOnAction(event -> {
            Alert errAlert = new Alert(Alert.AlertType.ERROR,"Something went wrong!");
            errAlert.show();
        });
        btnWarMsg.setOnAction(event -> {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING,"If you do this, you will die");
            warningAlert.show();
        });
        btnInfoMsg.setOnAction(event -> {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION, "Here is the information");
            infoAlert.show();
        });
        btnConfirmationMsg.setOnAction(event -> {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,"are you sure to delete this file",ButtonType.YES,ButtonType.NO);
            Optional<ButtonType> button = confirmationAlert.showAndWait();
            if (button.isPresent() && button.get() == ButtonType.YES){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        });
        btnCustomMsg.setOnAction(event -> {
            Alert customAlert = new Alert(Alert.AlertType.NONE, "This is the custom message",ButtonType.OK,ButtonType.NEXT,ButtonType.PREVIOUS);
            customAlert.setTitle("This is alert title");
            customAlert.setHeaderText("This is the Header Text");

            Image imgIcon = new Image(this.getClass().getResource("/img/play.png").toString(),32,31,true,true);
            ImageView imgView = new ImageView(imgIcon);
            customAlert.setGraphic(imgView);
            customAlert.show();
        });
    }
}
