package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnHelloSerialization;

    @FXML
    private Button btnManageStudents;

    @FXML
    void btnHelloSerializationOnAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/HelloView.fxml")).load()));
        primaryStage.setTitle("Hello Serialization");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    @FXML
    void btnManageStudentsOnAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/StudentView.fxml")).load()));
        primaryStage.setTitle("Manage Student");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

}
