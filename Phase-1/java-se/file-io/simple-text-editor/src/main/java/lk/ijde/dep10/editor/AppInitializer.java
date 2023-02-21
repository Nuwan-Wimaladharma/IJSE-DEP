package lk.ijde.dep10.editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijde.dep10.editor.controller.EditorSceneController;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/EditorScene.fxml")).load()));
        primaryStage.setTitle("Untitled file");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

}
