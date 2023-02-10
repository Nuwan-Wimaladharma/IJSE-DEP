package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        System.out.println("Working Remove");
    }

}

