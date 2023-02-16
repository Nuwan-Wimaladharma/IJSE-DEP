package lk.ijse.dep10.last.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsViewController {

    @FXML
    private Button btnApply;

    @FXML
    private Label lblMainTitle;

    @FXML
    private Label lblSubTitle;

    @FXML
    private TextField txtInput;

    private SimpleStringProperty observable;

    public void initData(SimpleStringProperty input){
        observable = input;
        txtInput.setText(input.getValue());
    }

    @FXML
    void btnApplyOnAction(ActionEvent event) {
        observable.setValue(txtInput.getText());
    }

}

