package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnOpenFileDialog;
    public Button btnSaveFileDialog;
    public Button btnDirectoryChooser;
    @FXML
    private Button btnNormalWindow;
    @FXML
    private Button btnModalWindow1;

    @FXML
    private Button btnModalWindow2;


    @FXML
    void btnNormalWIndowOnAction(ActionEvent event) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/MainForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Normal Window");
        window.show();
        window.centerOnScreen();
    }

    @FXML
    void btnModalWindow1OnAction(ActionEvent event) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);

        window.initModality(Modality.APPLICATION_MODAL); //current window appears even previous window closes (independent on the previous window(top level window))
        window.setTitle("Modal Window - 1");
        window.show();
        window.centerOnScreen();
    }

    @FXML
    void btnModalWindow2OnAction(ActionEvent event) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);

        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(btnModalWindow2.getScene().getWindow()); //cannot select previous window until close the new window
        window.setTitle("Modal Window - 2");
        window.show();
        window.centerOnScreen();
    }

    public void btnOpenFileDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a File");
        fileChooser.showOpenDialog(btnOpenFileDialog.getScene().getWindow()); //now this is a modal window to the parent window. If we pass "null" to here this becomes a top level window
    }
    public void btnSaveFileDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export a File");
        fileChooser.showSaveDialog(btnSaveFileDialog.getScene().getWindow());
    }

    public void btnDirectoryChooserOnAction(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser =new DirectoryChooser();
        directoryChooser.setTitle("Select a directory");
        File selectedDir = directoryChooser.showDialog(btnDirectoryChooser.getScene().getWindow());
        System.out.println("Selected directory: " + selectedDir); //creates a pointer to location of a directory
    }
}
