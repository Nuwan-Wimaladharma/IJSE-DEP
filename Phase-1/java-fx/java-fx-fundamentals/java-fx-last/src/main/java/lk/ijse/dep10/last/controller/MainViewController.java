package lk.ijse.dep10.last.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainViewController {

    @FXML
    private Button btnComboBox;

    @FXML
    private Button btnListView;

    @FXML
    private Button btnSceneSceneCommunication;

    @FXML
    private Button btnTableView;

    @FXML
    void btnComboBoxOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Combo Box Demo");

//        URL fxmlFile = getClass().getResource("/view/ComboBoxScene.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ComboBoxScene.fxml"));
//        AnchorPane root = new FXMLLoader(getClass().getResource("/view/ComboBoxScene.fxml")).load();
//        Scene scene = new Scene(new FXMLLoader(getClass().getResource("/view/ComboBoxScene.fxml")).load());

        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/ComboBoxScene.fxml")).load()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnListViewOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        URL fxmlFile = getClass().getResource("/view/ListViewScene.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        stage.setTitle("List View Demo");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.setResizable(true);
        stage.centerOnScreen();
    }

    @FXML
    void btnSceneSceneCommunicationOnAction(ActionEvent event) {

    }

    @FXML
    void btnTableViewOnAction(ActionEvent event) {

    }

    public void btnListViewExerciseOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        URL fxmlFile = getClass().getResource("/view/ListViewExercise.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        stage.setTitle("List View Exercise");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.centerOnScreen();
    }
}

