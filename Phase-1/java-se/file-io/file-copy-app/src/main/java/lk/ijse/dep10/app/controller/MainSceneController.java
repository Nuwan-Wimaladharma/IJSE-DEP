package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;

public class MainSceneController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSelectDestination;

    @FXML
    private Button btnSelectFile;

    @FXML
    private ProgressBar pgsBar;

    @FXML
    private TextField txtDirectoryView;

    @FXML
    private TextField txtFileView;

    @FXML
    private Label txtProgress;
    private long sizeOfTheSelectedFile;
    private String fileName;
    private File copyFile;
    private File pasteFile;
    double completedBytes;
    double percentage;

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FileInputStream fileInputStream = new FileInputStream(copyFile);
                FileOutputStream fileOutputStream = new FileOutputStream(pasteFile,true);
                int i = 1;
                while (true){
                    byte[] buffer = new byte[1024];
                    int read = fileInputStream.read(buffer);
                    if (read == 1024){
                        fileOutputStream.write(buffer);
                        completedBytes = (read * i);
                        percentage = (completedBytes / sizeOfTheSelectedFile) * 100;
                        updateProgress(percentage/100.0,1.0);
                        updateMessage(String.format("%.1f",percentage + " % Completed"));
                    }
                    if (read < 1024 && read >= 0){
                        fileOutputStream.write(buffer,0,read);
                        completedBytes = completedBytes + read;
                        percentage = (completedBytes / sizeOfTheSelectedFile) * 100;
                        updateProgress(percentage/100.0 , 1.0);
                        updateMessage(String.format("%.1f",percentage + " % Completed"));
                    }
                    if (read == -1) break;
                    i++;
                }
                fileInputStream.close();
                fileOutputStream.close();
                return null;
            }
        };
        new Thread(task).start();
        pgsBar.progressProperty().bind(task.progressProperty());
        txtProgress.textProperty().bind(task.messageProperty());
//        int i = 1;
//        while (true){
//            byte[] buffer = new byte[1024];
//            int read = fileInputStream.read(buffer);
//            if (read == 1024){
//                fileOutputStream.write(buffer);
//                completedBytes = (read * i);
//                percentage = (completedBytes / sizeOfTheSelectedFile) * 100;
//                txtProgress.setText(String.valueOf(percentage));
//            }
//            if (read < 1024 && read >= 0){
//                fileOutputStream.write(buffer,0,read);
//                completedBytes = completedBytes + read;
//                percentage = (completedBytes / sizeOfTheSelectedFile) * 100;
//                txtProgress.setText(String.valueOf(percentage));
//            }
//            if (read == -1) break;
//            i++;
//        }
        btnSelectFile.setDisable(true);
        btnSelectDestination.setDisable(true);
        txtFileView.setDisable(true);
        txtDirectoryView.setDisable(true);
        btnCopy.setDisable(true);
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        txtFileView.setText("File hasn't been selected yet");
        txtDirectoryView.setText("Directory hasn't been selected yet");
        btnCopy.setDisable(true);
        btnSelectFile.setDisable(false);
        btnSelectDestination.setDisable(false);
        txtFileView.setDisable(false);
        txtDirectoryView.setDisable(false);
        txtProgress.textProperty().unbind();
        txtProgress.setText("0 %");
        pgsBar.progressProperty().unbind();
        pgsBar.setProgress(0);
    }

    @FXML
    void btnSelectDestinationOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a directory");
        File directory = directoryChooser.showDialog(btnSelectDestination.getScene().getWindow());
        if (directory == null) return;
        pasteFile = new File(directory,fileName);
        txtDirectoryView.setText(directory.getPath());
        btnCopy.setDisable(false);
    }

    @FXML
    void btnSelectFileOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        File selectedFile = fileChooser.showOpenDialog(btnSelectFile.getScene().getWindow());
        if (selectedFile == null) return;
        sizeOfTheSelectedFile = selectedFile.length();
        fileName = selectedFile.getName();
        copyFile = selectedFile;
        FileInputStream fis = new FileInputStream(selectedFile);
        txtFileView.setText(selectedFile.getPath());

    }
}

