package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.dep10.serialization.model.Student;

import java.io.*;

public class HelloViewController {

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtStudentAddress;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtStudentName;

    private File homeDir = new File(System.getProperty("user.home"));
    private File desktopDir = new File(homeDir, "Desktop");
    private File studentFile = new File(desktopDir, "student.dep");

    public void initialize(){
        if (!studentFile.exists()) return;
        try {
            FileInputStream fis = new FileInputStream(studentFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            txtStudentID.setText(student.id);
            txtStudentName.setText(student.name);
            txtStudentAddress.setText(student.address);
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Student student = new Student(txtStudentID.getText(), txtStudentName.getText(), txtStudentAddress.getText());

        try {
            FileOutputStream fos = new FileOutputStream(studentFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            new Alert(Alert.AlertType.INFORMATION,"Successful...").show();
            //fos.close(); //not needed. because when oos got closed, fos is automatically closes
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to save the student, Try again..!").show();
        }
    }

}

