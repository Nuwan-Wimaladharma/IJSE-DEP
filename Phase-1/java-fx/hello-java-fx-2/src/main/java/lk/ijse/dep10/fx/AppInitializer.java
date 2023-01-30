package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Before launching JavaFX run-time environment");
        launch(args);
        System.out.println("JavaFX run-time environment destroyed");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Entry point");
        Platform.exit();
    }
}
