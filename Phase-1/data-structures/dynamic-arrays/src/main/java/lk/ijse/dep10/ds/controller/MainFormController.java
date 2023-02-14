package lk.ijse.dep10.ds.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import lk.ijse.dep10.ds.util.DynamicArray;

import java.util.ArrayList;
import java.util.Optional;

public class MainFormController {
    private DynamicArray numbers = new DynamicArray();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnContains;

    @FXML
    private Label btnNumber;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnPrintAll;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSize;

    @FXML
    private TextField btnTextField;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String value = btnTextField.getText();
        numbers.add(value);
        btnTextField.clear();
        btnTextField.requestFocus();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        numbers.clear();
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter the number");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        String input = optInput.get();
        System.out.println(numbers.contains(input));
    }

    @FXML
    void btnPrintAllOnAction(ActionEvent event) {
        System.out.println(numbers.printArray());
    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter the index");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        String input = optInput.get();
        int index = Integer.parseInt(input);
        if (index < 0 || index >= numbers.size()){
            System.err.println("Invalid Index");
            return;
        }
        System.out.println("Number is :" + numbers.get(index));
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter the index to remove");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        String input = optInput.get();
        int index = Integer.parseInt(input);
        if (index < 0 || index >= numbers.size()){
            System.err.println("Invalid Index");
            return;
        }
        numbers.remove(index);
    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        System.out.println("Size: " + numbers.size());
    }

    @FXML
    void btnTextFieldOnAction(ActionEvent event) {

    }

}
