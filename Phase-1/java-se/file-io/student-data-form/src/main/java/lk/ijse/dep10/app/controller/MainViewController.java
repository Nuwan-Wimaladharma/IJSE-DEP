package lk.ijse.dep10.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class MainViewController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;
    private ArrayList<Student> allStudents = new ArrayList<>();
    private ArrayList<Student> studentsAfterUpdating = new ArrayList<>();
    ArrayList<Student> studentsAfterDeleting = new ArrayList<>();
    File homeDir = new File(System.getProperty("user.home"));
    File desktopDir = new File(homeDir, "Desktop");
    File studentDetailsFile = new File(desktopDir,"student-details.nw");

    public void initialize(){
        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        //update all the table at startup

        //observableStudents = tblStudents.getItems();
//        if (tblStudents.getItems().size() != 0){
//            for (Student existingStudents : tblStudents.getItems()) {
//                allStudents.add(existingStudents);
//            }
//        }

        tblStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null){
                return;
            }
            btnSave.setDisable(false);
            btnDelete.setDisable(false);
            txtID.setText(current.getId());
            txtName.setText(current.getName());
            txtAddress.setText(current.getAddress());
        });
        btnDelete.setDisable(true);

        if (!studentDetailsFile.exists()) return;
        try {
            FileInputStream fis = new FileInputStream(studentDetailsFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            allStudents = (ArrayList) ois.readObject();
            for (int i = 0; i < allStudents.size(); i++) {
                tblStudents.getItems().add(allStudents.get(i));
            }
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        btnSave.setDisable(true);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> optButton = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the selected student", ButtonType.YES, ButtonType.NO).showAndWait();
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO){
            return;
        }
        try {
            File tempFileDelete = File.createTempFile("student","tempDelete");
            FileOutputStream fos = new FileOutputStream(tempFileDelete);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            if (studentsAfterUpdating.size() > 0){
                for (int i = 0; i < studentsAfterUpdating.size(); i++) {
                    if (studentsAfterUpdating.get(i).equals(tblStudents.getSelectionModel().getSelectedItem())) continue;
                    else {
                        studentsAfterDeleting.add(studentsAfterUpdating.get(i));
                    }
                }
            }
            else {
                for (int i = 0; i < allStudents.size(); i++) {
                    if (allStudents.get(i).equals(tblStudents.getSelectionModel().getSelectedItem())) continue;
                    else {
                        studentsAfterDeleting.add(allStudents.get(i));
                    }
                }
            }
            oos.writeObject(studentsAfterDeleting);
            fos.close();
            new Alert(Alert.AlertType.INFORMATION,"Deleted Successfully...").show();
            studentDetailsFile.delete();
            tempFileDelete.renameTo(studentDetailsFile);
        }
        catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Something went wrong. Try again...!").show();
        }
        tblStudents.getItems().remove(tblStudents.getSelectionModel().getSelectedItem());
        tblStudents.getSelectionModel().clearSelection();
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtID.clear();
        txtID.setText(generateNewID());
        txtName.clear();
        txtAddress.clear();
        btnSave.setDisable(false);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!isValidName(txtName.getText())){
            new Alert(Alert.AlertType.ERROR,"Invalid name. Name should be non-empty and can only have letters and spaces").show();
            txtName.requestFocus();
            return;
        }
        if (!isValidAddress(txtAddress.getText())){
            new Alert(Alert.AlertType.ERROR,"Invalid address. Address should be non-empty").show();
            txtAddress.requestFocus();
            return;
        }
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent == null){
            Student student = new Student(txtID.getText().strip(), txtName.getText().strip(), txtAddress.getText().strip());
            tblStudents.getItems().add(student);
            allStudents.add(student);
            try {
                FileOutputStream fos = new FileOutputStream(studentDetailsFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(allStudents);
                fos.close();
                new Alert(Alert.AlertType.INFORMATION,"Successful...").show();
            }
            catch (Exception e){
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR,"Something went wrong. Try again...!").show();
            }
        }
        if (selectedStudent != null){
            try {
                tblStudents.getItems().clear();
                File tempFileUpdate = File.createTempFile("student","tempUpdate");
                FileOutputStream fos = new FileOutputStream(tempFileUpdate);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                if (studentsAfterDeleting.size() > 0){
                    for (int i = 0; i < studentsAfterDeleting.size(); i++) {
                        if (studentsAfterDeleting.get(i).equals(selectedStudent)){
                            Student student = new Student(txtID.getText().strip(), txtName.getText().strip(), txtAddress.getText().strip());
                            studentsAfterUpdating.add(student);
                            tblStudents.getItems().add(student);
                        }
                        else {
                            studentsAfterUpdating.add(studentsAfterDeleting.get(i));
                            tblStudents.getItems().add(studentsAfterDeleting.get(i));
                        }
                    }
                }
                else{
                    for (int i = 0; i < allStudents.size(); i++) {
                        if (allStudents.get(i).equals(selectedStudent)){
                            Student student = new Student(txtID.getText().strip(), txtName.getText().strip(), txtAddress.getText().strip());
                            studentsAfterUpdating.add(student);
                            tblStudents.getItems().add(student);
                        }
                        else {
                            studentsAfterUpdating.add(allStudents.get(i));
                            tblStudents.getItems().add(allStudents.get(i));
                        }
                    }
                }
                oos.writeObject(studentsAfterUpdating);
                fos.close();
                new Alert(Alert.AlertType.INFORMATION,"Updated Successfully...").show();
                studentDetailsFile.delete();
                tempFileUpdate.renameTo(studentDetailsFile);
            }
            catch (Exception e){
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR,"Something went wrong. Try again...!").show();
            }
        }
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        btnSave.setDisable(true);
    }
    String generateNewID(){
        String id = "";
        ObservableList<Student> studentList = tblStudents.getItems();
        if (studentList.size() == 0){
            return "S001";
        }
        if (studentList.size() >= 1){
            String lastId = studentList.get(studentList.size()-1).getId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            id = String.format("S%03d",newId);
        }
        return id;
    }
    boolean isValidName(String input){
        boolean isValid = true;
        if (input.strip().isEmpty()){
            return false;
        }
        char[] chars = input.strip().toCharArray();
        for (char letters : chars) {
            if (letters == ' ') continue;
            if (!Character.isLetter(letters)){
                isValid = false;
            }
        }
        return isValid;
    }
    boolean isValidAddress(String input){
        boolean isValid = true;
        if (input.strip().isEmpty()){
            return false;
        }
        return isValid;
    }

}

