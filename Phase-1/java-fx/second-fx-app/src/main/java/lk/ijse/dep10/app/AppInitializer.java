package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        stage.setTitle("My Second FX Application");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        stage.centerOnScreen();
    }
}
