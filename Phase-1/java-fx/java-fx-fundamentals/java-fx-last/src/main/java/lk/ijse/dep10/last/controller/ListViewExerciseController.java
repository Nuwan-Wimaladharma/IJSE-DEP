package lk.ijse.dep10.last.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import lk.ijse.dep10.last.model.StudentInfo;
import lk.ijse.dep10.last.util.Gender;

import java.util.ArrayList;
import java.util.Optional;

public class ListViewExerciseController {

    public RadioButton rdoMale;
    public RadioButton rdoFemale;
    public Label lblGender;
    @FXML
    private ToggleGroup Gender;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnForward;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstModules;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<StudentInfo> lstStudents;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;
    public void initialize(){
        lstModules.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstSelectedModules.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        txtName.textProperty().addListener((value, previous, current) -> {
            txtName.getStyleClass().remove("invalid");
//            if (current.isEmpty() && !txtName.getStyleClass().contains("invalid")){
//                txtName.getStyleClass().add("invalid");
//                return;
//            }

            char[] chars = current.toCharArray();
            for (char c : chars) {
                if (!Character.isLetter(c) && !Character.isSpaceChar(c)){
                    txtName.getStyleClass().add("invalid");
                    return;
                }
            }
        });
        txtContact.textProperty().addListener((value, previous, current) -> {
            txtContact.getStyleClass().remove("invalid");
            btnAdd.setDisable(false);
            if (current.isEmpty()) return;
            if (current.isEmpty() && !txtContact.getStyleClass().contains("invalid")){
                txtContact.getStyleClass().add("invalid");
                return;
            }
            char[] chars = current.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0){
                    if (chars[0] != '0'){
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                }
                else if (i == 3){
                    if (chars[3] != '-'){
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                }
                else {
                    if (!Character.isDigit(chars[i]) || chars.length != 11){
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                }
            }
        });
        lstContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnRemove.setDisable(true); //btnRemove.setDisable(current == null);
            }
            else {
                btnRemove.setDisable(false);
            }
        });
        lstModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnForward.setDisable(true);
            }
            else {
                btnForward.setDisable(false);
            }
        });
        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnBack.setDisable(true);
            }
            else {
                btnBack.setDisable(false);
            }
        });
        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current == null);
            txtId.setText(current.id);
            txtName.setText(current.name);
            if (current.gender == lk.ijse.dep10.last.util.Gender.MALE){
                rdoMale.getToggleGroup().selectToggle(rdoMale);
            }
            else{
                rdoFemale.getToggleGroup().selectToggle(rdoFemale);
            }
            lstContacts.getItems().clear();
            lstContacts.getItems().addAll(current.contacts);
            lstSelectedModules.getItems().clear();
            lstSelectedModules.getItems().addAll(current.modules);
            lstModules.getItems().removeAll(current.modules);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        ObservableList<String> contactList = lstContacts.getItems();
        lstContacts.getSelectionModel().clearSelection();

        for (String contact : contactList) {
            if (txtContact.getText().strip().equals(contact)){
                txtContact.getStyleClass().add("invalid");
                return;
            }
        }
        contactList.add(txtContact.getText().strip());
        txtContact.clear();
        txtContact.requestFocus();
        lstContacts.getSelectionModel().clearSelection();
        lstContacts.getStyleClass().remove("invalid");
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        ObservableList<String> modules = lstModules.getItems();

        modules.addAll(lstSelectedModules.getSelectionModel().getSelectedItems());
        selectedModules.removeAll(lstSelectedModules.getSelectionModel().getSelectedItems());

        lstSelectedModules.getSelectionModel().clearSelection();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> optButton = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this student..?",ButtonType.YES,ButtonType.NO).showAndWait();
        lstStudents.getItems().remove(lstStudents.getSelectionModel().getSelectedItem());
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO) return;
        lstStudents.getItems().remove(lstStudents.getSelectionModel().getSelectedItem());
    }

    @FXML
    void btnForwardOnAction(ActionEvent event) {
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        selectedModules.addAll(lstModules.getSelectionModel().getSelectedItems());

        ObservableList<String> modules = lstModules.getItems();
        modules.removeAll(lstModules.getSelectionModel().getSelectedItems());

        lstModules.getSelectionModel().clearSelection();
        lstSelectedModules.getStyleClass().remove("invalid");
    }

    @FXML
    void btnNewStudentOnActon(ActionEvent event) {
        lstStudents.getSelectionModel().clearSelection();

        txtId.setText(generateNewStudentId());
        lblGender.setTextFill(Color.BLACK);

        txtName.getStyleClass().remove("invalid");
        txtContact.getStyleClass().remove("invalid");
        lstContacts.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");

        txtId.setDisable(false);
        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAdd.setDisable(false);
        //btnForward.setDisable(false);
        //btnBack.setDisable(false);
        btnSave.setDisable(false);
        rdoFemale.setDisable(false);
        rdoMale.setDisable(false);

        txtName.clear();
        txtContact.clear();
        rdoMale.getToggleGroup().selectToggle(null);

        ObservableList<String> moduleList = lstModules.getItems();
        moduleList.clear();
        moduleList.addAll("OOP","PF","DBMS","Angular","RxJS","React JS","Docker","Mongo DB","Cloud Native Applications");

        ObservableList<String> contactList = lstContacts.getItems();
        contactList.clear();

        ObservableList<String> selectedModuleList = lstSelectedModules.getItems();
        selectedModuleList.clear();

        txtName.requestFocus();

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> contactList = lstContacts.getItems();
        contactList.remove(lstContacts.getSelectionModel().getSelectedItem());
        lstContacts.getSelectionModel().clearSelection();
        txtContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isDataValid = true;
        lblGender.setTextFill(Color.BLACK);
        lstContacts.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");

        String name = txtName.getText();
        String contact = txtContact.getText();

        if (lstSelectedModules.getItems().size() < 3){
            isDataValid = false;
            lstSelectedModules.getStyleClass().add("invalid");
            lstModules.requestFocus();
        }

        if (lstContacts.getItems().isEmpty()){
            isDataValid = false;
            lstContacts.getStyleClass().add("invalid");
            txtContact.selectAll();
            txtContact.requestFocus();
        }

        if (rdoMale.getToggleGroup().getSelectedToggle() == null){
            isDataValid = false;
            rdoMale.requestFocus();
            lblGender.setTextFill(Color.RED);
        }

        if (name.isBlank() || txtName.getStyleClass().contains("invalid")){
            //new Alert(Alert.AlertType.ERROR, "Name is invalid or empty").showAndWait();
            isDataValid = false;
            if (!txtName.getStyleClass().contains("invalid")){
                txtName.getStyleClass().add("invalid");
            }
            txtName.selectAll();
            txtName.requestFocus();
        }
        if (!isDataValid) return;

        /* Business Validation */
        StudentInfo selectedStudent = lstStudents.getSelectionModel().getSelectedItem();

        ObservableList<StudentInfo> studentList = lstStudents.getItems();
        for (StudentInfo student : studentList) {
            for (String contactNumber : student.contacts) {
                if (student == selectedStudent) continue;
                if (isDuplicate(contactNumber)){
                    new Alert(Alert.AlertType.ERROR, "Contact number " + contactNumber + " already exists").showAndWait();
                    lstContacts.getStyleClass().add("invalid");
                    lstContacts.requestFocus();
                    return;
                }
            }
        }
        if (selectedStudent == null){
            StudentInfo student = new StudentInfo(txtId.getText(),
                    txtName.getText(),
                    rdoMale.isSelected() ? lk.ijse.dep10.last.util.Gender.MALE : lk.ijse.dep10.last.util.Gender.FEMALE,
                    new ArrayList<>(lstContacts.getItems()),
                    new ArrayList<>(lstSelectedModules.getItems()));
            studentList.add(student);
        }
        else{
            selectedStudent.name = txtName.getText().strip();
            selectedStudent.gender = rdoMale.isSelected()? lk.ijse.dep10.last.util.Gender.MALE: lk.ijse.dep10.last.util.Gender.FEMALE;
            selectedStudent.contacts.clear();
            selectedStudent.contacts.addAll(new ArrayList<>(lstContacts.getItems()));
            selectedStudent.modules.clear();
            selectedStudent.modules.addAll(new ArrayList<>(lstSelectedModules.getItems()));
        }

        btnNewStudent.fire();
    }
    private boolean isDuplicate(String contact){
        for (String enteredContact : lstContacts.getItems()) {
            if (enteredContact.equals(contact)){
                return true;
            }
        }
        return false;
    }

    @FXML
    void lstContactsOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE){
            btnRemove.fire();
        }
    }

    @FXML
    void lstModulesOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            btnForward.fire();
        }
    }

    @FXML
    void lstSelectedModulesOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE){
            btnBack.fire();
        }
    }

    @FXML
    void lstStudentsOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE){
            btnDelete.fire();
        }
    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }
    private String generateNewStudentId() {
        ObservableList<StudentInfo> studentList = lstStudents.getItems();
        if (studentList.isEmpty()) return "S001";
        String lastStudentId = studentList.get(studentList.size()-1).id;
        int newId = Integer.parseInt(lastStudentId.substring(1)) + 1;
        return String.format("S%03d",newId);
    }

}

