package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.model.Student;
import lk.ijse.dep10.app.util.Gender;

import java.util.ArrayList;

public class MainViewController {

    //public TableView tblStudentDetails;
    public Label lblShortCode;
    public ToggleGroup Gender;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAddNewStudent;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSelectModule;

    @FXML
    private Button btnUnselectModule;

    @FXML
    private CheckBox chkPartTime;

    @FXML
    private ComboBox<String> cmbDegrees;

    @FXML
    private Label lblStudentID;

    @FXML
    private ListView<String> lstAllModules;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private TableView<Student> tblStudentDetails;


    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtShortCode;

    @FXML
    private TextField txtStudentName;
    public void initialize(){
        tblStudentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contacts"));
        tblStudentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("degree"));
        tblStudentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("modules"));
        tblStudentDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("partTime"));

        txtStudentName.setDisable(true);
        rdoMale.setDisable(true);
        rdoFemale.setDisable(true);
        txtContact.setDisable(true);
        btnAdd.setDisable(true);
        btnRemove.setDisable(true);
        cmbDegrees.setDisable(true);
        lstAllModules.setDisable(true);
        btnSelectModule.setDisable(true);
        btnUnselectModule.setDisable(true);
        lstSelectedModules.setDisable(true);
        chkPartTime.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
        tblStudentDetails.setDisable(true);

        ObservableList<String> degreePrograms = cmbDegrees.getItems();
        degreePrograms.addAll("Engineering","Medicine","Management","Physical","Information Technology");

        ObservableList<String> allModules = lstAllModules.getItems();

        cmbDegrees.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            if (current == null){
                return;
            }
            if (current.equals("Engineering")){
                allModules.clear();
                lblShortCode.setText("ENG");
                allModules.addAll("Mathematics","Mechanics","Material Science","Electronic and Electrical","Hydraulic Engineering");
            }
            if (current.equals("Medicine")){
                allModules.clear();
                lblShortCode.setText("MED");
                allModules.addAll("Anatomy","Venereology","Neurology","Orthopaedic Surgery","Cardiology");
            }
            if (current.equals("Management")){
                allModules.clear();
                lblShortCode.setText("MNGT");
                allModules.addAll("Digital Analytics","Marketing Pathway","Digital Business Pathway","Strategic Management","Global Marketing Management");
            }
            if (current.equals("Physical")){
                allModules.clear();
                lblShortCode.setText("PHY");
                allModules.addAll("Applied Mathematics","Combined Mathematics","Physics","Chemistry","Information and Communication Technology (ICT)");
            }
            if (current.equals("Information Technology")){
                allModules.clear();
                lblShortCode.setText("IT");
                allModules.addAll("Data Science","Software Engineering","Cyber Security","Information Systems Engineering","Computer Science");
            }
        });

        lstAllModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnSelectModule.setDisable(true);
                return;
            }
            btnSelectModule.setDisable(false);
        });

        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnUnselectModule.setDisable(true);
                return;
            }
            btnUnselectModule.setDisable(false);
        });

        lstContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                btnRemove.setDisable(true);
                return;
            }
            btnRemove.setDisable(false);
        });

        txtStudentName.textProperty().addListener((value, previous, current) -> {
            txtStudentName.getStyleClass().remove("invalid");
            if (current.trim().isEmpty()){
                txtStudentName.getStyleClass().add("invalid");
                return;
            }
            char[] charsOfName = current.trim().toCharArray();
            for (char c : charsOfName) {
                if (!Character.isLetter(c) && c != ' '){
                    txtStudentName.getStyleClass().add("invalid");
                    return;
                }
            }
        });

        txtContact.textProperty().addListener((value, previous, current) -> {
            txtContact.getStyleClass().remove("invalid");
            btnAdd.setDisable(false);
            if (current.trim().isEmpty()){
                btnAdd.setDisable(true);
                return;
            }
            if (current.trim().isEmpty() && !txtContact.getStyleClass().contains("invalid")){
                txtContact.getStyleClass().add("invalid");
                btnAdd.setDisable(true);
                return;
            }
            char[] chars = current.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0){
                    if (chars[0] != '0' || chars.length != 11){
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
    }

    @FXML
    void btnAddNewStudentOnAction(ActionEvent event) {
        txtStudentName.setDisable(false);
        lblStudentID.setText("Generated ID");
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);
        txtContact.setDisable(false);
        cmbDegrees.setDisable(false);
        cmbDegrees.getSelectionModel().clearSelection();
        lblShortCode.setText("No Degree hasn't been selected");
        lstAllModules.setDisable(false);
        lstSelectedModules.setDisable(false);
        chkPartTime.setDisable(false);
        btnSave.setDisable(false);

        txtStudentName.clear();
        txtStudentName.getStyleClass().remove("invalid");
        txtContact.clear();
        lstContacts.getItems().clear();
        lstAllModules.getItems().clear();
        lstSelectedModules.getItems().clear();
        chkPartTime.setSelected(false);
        rdoMale.setSelected(false);
        rdoFemale.setSelected(false);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String enteredContact = txtContact.getText();
        ObservableList<String> allContacts = lstContacts.getItems();
        if (allContacts.contains(enteredContact)){
            Alert warningAlert = new Alert(Alert.AlertType.WARNING,"Contact number " + enteredContact + " is already added. Please add another one");
            warningAlert.show();
            txtContact.selectAll();
            txtContact.requestFocus();
        }
        else {
            allContacts.add(enteredContact);
            txtContact.selectAll();
            txtContact.requestFocus();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> allContacts = lstContacts.getItems();
        String selectedContact = lstContacts.getSelectionModel().getSelectedItem();
        allContacts.remove(selectedContact);
        lstContacts.getSelectionModel().clearSelection();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isDataValid = true;

        if (lstSelectedModules.getItems().size() < 3){
            isDataValid = false;
            lstSelectedModules.getStyleClass().add("invalid");
            lstAllModules.requestFocus();
        }

        if (lstContacts.getItems().size() < 1){
            isDataValid = false;
            lstContacts.getStyleClass().add("invalid");
            txtContact.requestFocus();
        }

        if (rdoMale.getToggleGroup().getSelectedToggle() == null){
            isDataValid = false;
            rdoMale.getStyleClass().add("invalid");
            rdoFemale.getStyleClass().add("invalid");
            rdoMale.requestFocus();
        }

        if (txtStudentName.getText().isBlank() || txtStudentName.getStyleClass().contains("invalid")){
            isDataValid = false;
            txtStudentName.getStyleClass().add("invalid");
            txtStudentName.requestFocus();
        }

        if (isDataValid = false){
            return;
        }
        if (isDataValid = true){
            lblStudentID.setText(generateNewStudentID(lblShortCode.getText()));
            tblStudentDetails.setDisable(false);
            Student student = new Student(lblStudentID.getText(),txtStudentName.getText().strip(),rdoMale.isSelected() ? lk.ijse.dep10.app.util.Gender.MALE: lk.ijse.dep10.app.util.Gender.FEMALE,new ArrayList<>(lstContacts.getItems()),cmbDegrees.getSelectionModel().getSelectedItem(),new ArrayList<>(lstSelectedModules.getItems()),chkPartTime.isSelected() ? "YES": "NO");
            tblStudentDetails.getItems().add(student);
        }
    }

    @FXML
    void btnSelectModuleOnAction(ActionEvent event) {
        ObservableList<String> allModules = lstAllModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        String selectedModule = lstAllModules.getSelectionModel().getSelectedItem();
        allModules.remove(selectedModule);
        selectedModules.add(selectedModule);
        lstAllModules.getSelectionModel().clearSelection();
    }

    @FXML
    void btnUnselectModuleOnAction(ActionEvent event) {
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        ObservableList<String> allModules = lstAllModules.getItems();
        String unselectedModule = lstSelectedModules.getSelectionModel().getSelectedItem();
        selectedModules.remove(unselectedModule);
        allModules.add(unselectedModule);
        lstSelectedModules.getSelectionModel().clearSelection();
    }

    @FXML
    void chkPartTimeOnAction(ActionEvent event) {

    }

    @FXML
    void cmbDegreesOnAction(ActionEvent event) {

    }

    @FXML
    void rdoFemaleOnAction(ActionEvent event) {

    }

    @FXML
    void rdoMaleOnAction(ActionEvent event) {

    }
    public String generateNewStudentID(String shortCode){
        ObservableList<Student> studentList = tblStudentDetails.getItems();
        String idFirstPart = "S-" + shortCode + "-";
        if (studentList.isEmpty()){
            return idFirstPart + "001";
        }
        String finalString = "";
        for (int i = studentList.size()-1; i >= 0; i--) {
            String identity = studentList.get(i).getId();
            String[] parts = identity.split("-");
            if (shortCode.equals(parts[1])){
                int newId = Integer.parseInt(parts[2]) + 1;
                String stringId = Integer.toString(newId);
                if (stringId.length() == 1){
                    finalString = idFirstPart + "00" + stringId;
                }
                if (stringId.length() == 2){
                    finalString = idFirstPart + "0" + stringId;
                }
                if (stringId.length() >= 3){
                    finalString = idFirstPart + stringId;
                }
                break;
            }
            else {
                finalString = idFirstPart + "001";
            }
        }
        return finalString;
    }

}

