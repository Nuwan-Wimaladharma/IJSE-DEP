package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.dep10.serialization.model.Customer;
import lk.ijse.dep10.serialization.model.Teacher;

import java.io.*;

public class SerialVersionUIDViewController {

    @FXML
    private Button btnDeserialize;

    @FXML
    private Button btnSerialize;

    File file = new File("customer.dep10");

    @FXML
    void btnDeserializeOnAction(ActionEvent event) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Customer c001 = (Customer) ois.readObject();
            Teacher t1 = (Teacher) ois.readObject();
            System.out.println(t1);
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to fetch the customer").show();
        }


    }

    @FXML
    void btnSerializeOnAction(ActionEvent event) {
        //Customer c001 = new Customer("C001", "Kasun", "Galle");
        Teacher t1 = new Teacher(1, "Ruwan");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t1);
            oos.close();
            System.out.println("Serialization Done");
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer").show();
        }


    }

}
