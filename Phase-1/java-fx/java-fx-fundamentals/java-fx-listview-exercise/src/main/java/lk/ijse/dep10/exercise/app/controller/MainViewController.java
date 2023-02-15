package lk.ijse.dep10.exercise.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.dep10.exercise.app.model.Student;

import java.util.ArrayList;
import java.util.Optional;

public class MainViewController {

    public Button btnNewStudent;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSelectModules;

    @FXML
    private Button btnUnselectModules;

    @FXML
    private ListView<String> lstAllModules;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<Student> lstStudentDetails;

    @FXML
    private TextField txtStudentContact;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtStudentName;

    public void initialize(){
        ObservableList<String> modules = lstAllModules.getItems();
        modules.addAll("Programming Fundamentals","Java","Java Script","Angular","React","SpringBoot");

        lstAllModules.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            if (current == null){
                btnSelectModules.setDisable(true);
            }
            if (current != null){
                btnSelectModules.setDisable(false);
            }
        });
        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            if (current == null){
                btnUnselectModules.setDisable(true);
            }
            if (current != null){
                btnUnselectModules.setDisable(false);
            }
        });
        lstContacts.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            if (current == null){
                txtStudentContact.requestFocus();
                btnRemove.setDisable(true);
                return;
            }
            if (current != null){
                btnRemove.setDisable(false);
            }
            txtStudentContact.requestFocus();
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        txtStudentContact.getStyleClass().remove("invalid");
        String contactNumber = txtStudentContact.getText().trim();
        boolean isValidPhoneNumber = false;
        char[] numbers = contactNumber.toCharArray();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3) continue;
            else {
                if (!Character.isDigit(numbers[i])){
                    count += 1;
                }
            }
        }
        if (count == 0 && numbers.length == 11 && numbers[3] == '-'){
            isValidPhoneNumber = true;
        }
        ObservableList<String> contactNumbers = lstContacts.getItems();
        if (isValidPhoneNumber){
            contactNumbers.add(contactNumber);
            //btnRemove.setDisable(false);
            //btnSelectModules.setDisable(false);
            txtStudentContact.clear();
            txtStudentContact.requestFocus();
        }
        else {
            txtStudentContact.getStyleClass().add("invalid");
            txtStudentContact.selectAll();
            txtStudentContact.requestFocus();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        String selectedContactToRemove = lstContacts.getSelectionModel().getSelectedItem();
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete " + selectedContactToRemove, ButtonType.YES,ButtonType.NO);
        confirmationAlert.setTitle("Remove Confirmation");
        Optional<ButtonType> button = confirmationAlert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.YES){
            int index = lstContacts.getSelectionModel().getSelectedIndex();
            lstContacts.getItems().remove(index);
        }
        lstContacts.getSelectionModel().clearSelection();
        txtStudentContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {;
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        ObservableList<String> contactNumbers = lstContacts.getItems();
        String inputName = txtStudentName.getText().trim();
        boolean isValidName = true;
        boolean isValid = true;
        char[] letters = inputName.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ' ') continue;
            if (!Character.isLetter(letters[i])){
                isValidName = false;
            }
        }
        if (selectedModules.size() < 3){
            lstSelectedModules.getStyleClass().add("invalid");
            lstSelectedModules.requestFocus();
            isValid = false;
        }
        if (contactNumbers.size() == 0){
            lstContacts.getStyleClass().add("invalid");
            lstContacts.requestFocus();
            isValid = false;
        }
        if (!isValidName){
            txtStudentName.getStyleClass().add("invalid");
            txtStudentName.selectAll();
            txtStudentName.requestFocus();
            isValid = false;
        }

        if (isValid == false){
            return;
        }
        if (isValid == true){
            ObservableList<Student> studentDetailsList= lstStudentDetails.getItems();
        }

    }

    @FXML
    void btnSelectModulesOnAction(ActionEvent event) {
        ObservableList<String> allModules = lstAllModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        String selectedModule = lstAllModules.getSelectionModel().getSelectedItem();
        selectedModules.add(selectedModule);
        lstAllModules.getSelectionModel().clearSelection();
        //btnUnselectModules.setDisable(false);
        //allModules.remove(selectedModule);
        btnSave.setDisable(false);
    }

    @FXML
    void btnUnselectModulesOnAction(ActionEvent event) {
        ObservableList<String> allModules = lstAllModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        String selectedModuleToUnselect = lstSelectedModules.getSelectionModel().getSelectedItem();
        //allModules.add(selectedModuleToUnselect);
        lstSelectedModules.getSelectionModel().clearSelection();
        selectedModules.remove(selectedModuleToUnselect);
    }

    public int idGenerateNumber = 1;
    public void btnNewStudentOnAction(ActionEvent actionEvent) {
        ObservableList<String> allModules = lstAllModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        ObservableList<String> contactNumbers = lstContacts.getItems();
        //allModules.clear();
        //allModules.addAll("Programming Fundamentals","Java","Java Script","Angular","React","SpringBoot");
        contactNumbers.clear();
        selectedModules.clear();
        ArrayList idNumbers = idGenerator(idGenerateNumber);
        String stdId = (String) idNumbers.get(idGenerateNumber-1);
        txtStudentID.setText(stdId);
        txtStudentName.setDisable(false);
        txtStudentContact.setDisable(false);
        btnAdd.setDisable(false);

        txtStudentName.clear();
        txtStudentContact.clear();

        txtStudentID.getStyleClass().remove("invalid");
        txtStudentName.getStyleClass().remove("invalid");
        txtStudentContact.getStyleClass().remove("invalid");
        lstContacts.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");
        idGenerateNumber += 1;
    }
    public ArrayList idGenerator(int x){
        ArrayList finalIds = new ArrayList<>();
        ArrayList tempIds = new ArrayList<>();
        for (int i = 1; i <= x ; i++) {
            tempIds.add(i);
        }
        for (int i = 0; i < tempIds.size(); i++) {
            String number = tempIds.get(i).toString();
            if (number.length() == 1){
                String finalId = "S00" + number;
                finalIds.add(finalId);
            }
            if (number.length() == 2){
                String finalId = "S0" + number;
                finalIds.add(finalId);
            }
            if (number.length() >= 3){
                String finalId = "S" + number;
                finalIds.add(finalId);
            }
        }
        return finalIds;
    }
}

