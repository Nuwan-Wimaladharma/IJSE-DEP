package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        form();
    }
    private void form(){
        Stage formStage = new Stage();
        formStage.setTitle("STUDENT FORM");
        formStage.setMinWidth(400);
        formStage.setMinHeight(400);

        Label topic = new Label("Student Form");
        topic.setFont(Font.font("Ubuntu",28));
        topic.setPadding(new Insets(0,0,25,0));
        topic.setTextFill(Color.DARKBLUE);
        Label id = new Label("Id : ");
        Label name = new Label("Name : ");
        Label nic = new Label("NIC : ");
        Label contact = new Label("Contact : ");

        Label errId = new Label("Invalid Id !...Please Try Again...");
        errId.setTextFill(Color.RED);
        errId.setVisible(false);
        Label errName = new Label("Invalid Name !...Please Try Again...");
        errName.setTextFill(Color.RED);
        errName.setVisible(false);
        Label errNic = new Label("Invalid NIC !...Please Try Again...");
        errNic.setTextFill(Color.RED);
        errNic.setVisible(false);
        Label errContact = new Label("Invalid Contact !...Please Try Again...");
        errContact.setTextFill(Color.RED);
        errContact.setVisible(false);

        TextField idText = new TextField();
        idText.setPromptText("SXXX");
        TextField nameText = new TextField();
        nameText.setPromptText("Shouldn't Be Empty");
        TextField nicText = new TextField();
        nicText.setPromptText("XXXXXXXXXv");
        TextField contactText = new TextField();
        contactText.setPromptText("XXX-XXXXXXX");

        Button validateButton = new Button("VALIDATE");
        validateButton.setBackground(Background.fill(Color.LIGHTGREEN));
        validateButton.setDefaultButton(true);

        validateButton.setOnAction(event -> {
            if (!validateId(idText.getText().trim())){
                errId.setVisible(true);
            }
            if (!validateName(nameText.getText().trim())){
                errName.setVisible(true);
            }
            if (!validateNIC(nicText.getText().trim())){
                errNic.setVisible(true);
            }
            if (!validateContact(contactText.getText().trim())){
                errContact.setVisible(true);
            }
            if (validateId(idText.getText().trim()) && validateName(nameText.getText().trim()) && validateNIC(nicText.getText().trim()) && validateContact(contactText.getText().trim())){
                Platform.exit();
            }
        });

        GridPane formContainer = new GridPane();
        formContainer.setMinWidth(250);
        formContainer.setMaxWidth(Double.MAX_VALUE);
        formContainer.add(topic,0,0,2,1);
        formContainer.add(id,0,1);
        formContainer.add(idText,1,1);
        formContainer.add(errId,1,2);
        formContainer.add(name,0,3);
        formContainer.add(nameText,1,3);
        formContainer.add(errName,1,4);
        formContainer.add(nic,0,5);
        formContainer.add(nicText,1,5);
        formContainer.add(errNic,1,6);
        formContainer.add(contact,0,7);
        formContainer.add(contactText,1,7);
        formContainer.add(errContact,1,8);
        formContainer.add(validateButton,0,9,2,1);
        formContainer.setGridLinesVisible(false);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setPadding(new Insets(20));
        formContainer.setVgap(10);
        formContainer.setHgap(10);
        GridPane.setHalignment(topic, HPos.CENTER);
        GridPane.setHalignment(validateButton,HPos.CENTER);
        GridPane.setHalignment(id,HPos.RIGHT);
        GridPane.setHalignment(name,HPos.RIGHT);
        GridPane.setHalignment(nic,HPos.RIGHT);
        GridPane.setHalignment(contact,HPos.RIGHT);
        GridPane.setHgrow(idText,Priority.ALWAYS);

        Scene formScene = new Scene(formContainer);
        formStage.setScene(formScene);
        formStage.show();
        formStage.centerOnScreen();
    }
    private boolean validateId(String idNumber){
        boolean isValidNumber = false;
        char[] chars = idNumber.toCharArray();
        if (chars.length == 4 && chars[0] == 'S' && Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3])){
            isValidNumber = true;
        }
        return isValidNumber;
    }
    private boolean validateName(String name){
        boolean isValidName = false;
        char[] chars = name.toCharArray();
        if (chars.length >= 1){
            isValidName = true;
        }
        return isValidName;
    }
    private boolean validateNIC(String NIC){
        boolean isValidId = false;
        char[] chars = NIC.toCharArray();
        if (chars.length == 10 && (chars[chars.length-1] == 'V' || chars[chars.length-1] == 'v')){
            int count = 0;
            for (int i = 0; i < chars.length-1; i++) {
                if (Character.isDigit(chars[i])){
                    count += 1;
                }
            }
            if (count == 9){
                isValidId = true;
            }
        }
        return isValidId;
    }
    private boolean validateContact(String contact){
        boolean isValidContact = false;
        char[] chars = contact.toCharArray();
        if (chars.length == 11 && chars[3] == '-'){
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (i == 3){
                    continue;
                }
                else {
                    if (Character.isDigit(chars[i])){
                        count += 1;
                    }
                }
            }
            if (count == 10){
                isValidContact = true;
            }
        }
        return isValidContact;
    }
}
