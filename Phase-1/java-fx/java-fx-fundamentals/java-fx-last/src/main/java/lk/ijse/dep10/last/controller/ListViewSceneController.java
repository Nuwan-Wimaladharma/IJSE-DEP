package lk.ijse.dep10.last.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.last.model.Student;

import java.util.Optional;


public class ListViewSceneController {

    public ListView<Student> lstStudents;
    public TextField txtAddress;
    public Button btnDelete;
    public Button btnSave;
    public TextField txtName;
    public TextField txtId;
    public Button btnNew;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblSelectedName;

    @FXML
    private ListView<String> lstNames;

    @FXML
    private TextField txtInput;

    public void initialize(){
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                lblSelectedName.setText("No name has been selected");
                btnRemove.setDisable(true);
                return;
            }
            lblSelectedName.setText("Selected name: " + current);
            btnRemove.setDisable(false);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);
            txtId.setText(current.id);
            txtName.setText(current.name);
            txtAddress.setText(current.address);

            txtId.setDisable(true);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = txtInput.getText();
        if (input.isBlank()){
            txtInput.selectAll();
            txtInput.requestFocus();
            return;
        }

        ObservableList<String> names = lstNames.getItems();
        names.add(txtInput.getText().strip());

        lstNames.getSelectionModel().clearSelection();
        txtInput.clear();
        txtInput.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete " + selectedName,ButtonType.YES,ButtonType.NO);
        confirmationAlert.setTitle("Delete Confirmation");
        Optional<ButtonType> button = confirmationAlert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.YES){
            int index = lstNames.getSelectionModel().getSelectedIndex();
            lstNames.getItems().remove(index);
        }
        lstNames.getSelectionModel().clearSelection();
        txtInput.requestFocus();

        //confirmation Message
        //lstNames.getSelectionModel().getSelectedItems() --> Value
        //lstNames.getSelectionModel().getSelectedIndex() --> Index
        //lstNames.getSelectionModel().clearSelection();
    }

    public void lstNamesOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE){
            btnRemove.fire();
        }
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        btnSave.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();

        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");

        txtId.requestFocus();

        lstStudents.getSelectionModel().clearSelection();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        boolean isValid = true;

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");

        if (address.isBlank() || address.trim().length() < 3){
            txtAddress.getStyleClass().add("invalid");
            txtAddress.selectAll();
            txtAddress.requestFocus();
            isValid = false;
        }

        if (name.isBlank()){
            txtName.getStyleClass().add("invalid");
            txtName.selectAll();
            txtName.requestFocus();
            isValid = false;
        }

        if (id.isBlank() || id.charAt(0) != 'S' || id.substring(1).length() < 3 || !isNumber(id.substring(1))){
            txtId.getStyleClass().add("invalid");
            txtId.selectAll();
            txtId.requestFocus();
            isValid = false;
        }
        if (!isValid) return;

        if (lstStudents.getSelectionModel().getSelectedIndex() == -1) {
            ObservableList<Student> studentList = lstStudents.getItems();
            for (Student student : studentList) {
                if (student.id.equals(id)){
                    txtId.getStyleClass().add("invalid");
                    txtId.selectAll();
                    txtId.requestFocus();
                    return;
                }
            }
            Student student = new Student(id,name,address);
            studentList.add(student);
        }
        else{
            Student selectedStudent = lstStudents.getSelectionModel().getSelectedItem();
            selectedStudent.name = name;
            selectedStudent.address = address;
        }

        btnNew.fire();
    }
    private boolean isNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Student selectedStudent = lstStudents.getSelectionModel().getSelectedItem();
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete the student Id: " + selectedStudent.id, ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> optButton = confirmationAlert.showAndWait();
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO) return;

        lstStudents.getItems().remove(selectedStudent);
        btnNew.fire();
    }

    public void txtOnAction(ActionEvent actionEvent) {
        btnSave.fire();
    }

    public void lstStudentOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE){
            btnDelete.fire();
        }
    }
}

