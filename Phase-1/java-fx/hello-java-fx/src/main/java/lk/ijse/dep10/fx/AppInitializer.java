package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Just before the launching javaFX run-time environment");
        launch(args);
        System.out.println("javaFX run-time environment destroyed");
    } //when calling launch method, javafx run-time environment starts

    @Override
    //This start() method act as main method in javafx(entry method). In main() method is used only for calling launch() method
    public void start(Stage primaryStage) {
        System.out.println("Entry Point");
        Platform.exit(); //to exit javaFX runtime environment
    }
}
