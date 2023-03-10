package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lk.ijse.dep10.serialization.model.inherit2.D;

import java.io.*;

public class InheritanceView2Controller {

    @FXML
    private Button btnDeSerializeD;

    @FXML
    private Button btnSerializeD;

    private File file2 = new File("file2.dep10");

    @FXML
    void btnDeSerializeDOnAction(ActionEvent event) {

        try {
            FileInputStream fis = new FileInputStream(file2);
            ObjectInputStream ois = new ObjectInputStream(fis);

            D dInstance =  (D) ois.readObject();

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnSerializeDOnAction(ActionEvent event) {
        D dInstance = new D(50, 60, 70, 80);

        try {
            FileOutputStream fos = new FileOutputStream(file2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dInstance);

            oos.close();
            System.out.println("Serialization Done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
