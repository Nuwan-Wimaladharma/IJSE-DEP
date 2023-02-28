package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class MainViewController {

    @FXML
    private Button btnBrowseSource;

    @FXML
    private Button btnBrowseTarget;

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnMove;

    @FXML
    private ProgressBar prg;

    @FXML
    private Label txtPrg;

    @FXML
    private TextField txtSource;

    @FXML
    private TextField txtTarget;
    private File srcFile;
    private File targetFile;
    private String fileName;
    private ArrayList<File> allFiles = new ArrayList<>();
    private double totalLength = 0.0;

    @FXML
    void btnBrowseSourceOnAction(ActionEvent event) {
        txtSource.clear();
        txtPrg.textProperty().unbind();
        prg.progressProperty().unbind();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        txtSource.setText(String.valueOf(chooser.getSelectedFile()));
        fileName = chooser.getSelectedFile().getName();
        srcFile = chooser.getSelectedFile();
        btnDelete.setDisable(false);
        prg.setProgress(0.0);
        txtPrg.setText("0 % Completed");
    }

    @FXML
    void btnBrowseTargetOnAction(ActionEvent event) {
        txtTarget.clear();
        txtPrg.textProperty().unbind();
        prg.progressProperty().unbind();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a directory");
        File directory = directoryChooser.showDialog(btnBrowseTarget.getScene().getWindow());
        if (directory == null) return;
        txtTarget.setText(directory.getPath());
        if (!txtSource.getText().isEmpty()){
            targetFile = new File(directory,fileName);
            btnCopy.setDisable(false);
            btnMove.setDisable(false);
            prg.setProgress(0.0);
            txtPrg.setText("0 % Completed");
        }
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {
        if (srcFile.isFile()){
            if (targetFile.exists()){
                Optional<ButtonType> optResult = new Alert(Alert.AlertType.CONFIRMATION,"File already exists, are you sure to replace the file...?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (optResult.isEmpty() || optResult.get() == ButtonType.NO) return;
            }
            btnCopy.getScene().getWindow();
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    FileInputStream fis = new FileInputStream(srcFile);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    double write = 0.0;
                    while (true){
                        byte[] buffer = new byte[1024];
                        int read = fis.read(buffer);
                        if (read == -1) break;
                        fos.write(buffer,0,read);
                        write += read;
                        updateMessage(String.format("%2.2f",((write * 100.0)/srcFile.length())).concat("% Copied"));
                        updateProgress(write,srcFile.length());
                    }
                    fis.close();
                    fos.close();
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
        }
        if (srcFile.isDirectory()){
            findFiles(srcFile);
            for (File allFile : allFiles) {
                totalLength += allFile.length();
            }
            if (targetFile.exists()){
                Optional<ButtonType> optResult = new Alert(Alert.AlertType.CONFIRMATION,"File already exists, are you sure to replace the file...?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (optResult.isEmpty() || optResult.get() == ButtonType.NO) return;
            }
            btnCopy.getScene().getWindow();
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    double write = 0.0;
                    for (File allFile : allFiles) {
                        File tempFileToCopyFolder = File.createTempFile("file","copyFolder");
                        FileInputStream fis = new FileInputStream(allFile);
                        FileOutputStream fos = new FileOutputStream(tempFileToCopyFolder);
                        while (true){
                            byte[] buffer = new byte[1024];
                            int read = fis.read(buffer);
                            if (read == -1) break;
                            fos.write(buffer,0,read);
                            write += read;
                            updateMessage(String.format("%2.2f",((write * 100.0)/totalLength)).concat("% Copied"));
                            updateProgress(write,totalLength);
                        }
                        tempFileToCopyFolder.delete();
                        fis.close();
                        fos.close();
                    }
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
            FileUtils.copyDirectory(srcFile,targetFile);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException{
        if (srcFile.isFile()){
            if (!txtSource.getText().isEmpty()) {
                Optional<ButtonType> optResult = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete " + fileName + " ...?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (optResult.isEmpty() || optResult.get() == ButtonType.NO) return;
            }
            btnDelete.getScene().getWindow();
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    File tempFileToDelete = File.createTempFile("file","delete");
                    FileInputStream fis = new FileInputStream(srcFile);
                    FileOutputStream fos = new FileOutputStream(tempFileToDelete);
                    double write = 0.0;
                    while (true){
                        byte[] buffer = new byte[1024];
                        int read = fis.read(buffer);
                        if (read == -1) break;
                        fos.write(buffer,0,read);
                        write += read;
                        updateMessage(String.format("%2.2f",((write * 100.0)/srcFile.length())).concat("% Deleted"));
                        updateProgress(write,srcFile.length());
                    }
                    srcFile.delete();
                    tempFileToDelete.delete();
                    fis.close();
                    fos.close();
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
        }
        if (srcFile.isDirectory()){
            findFiles(srcFile);
            for (File allFile : allFiles) {
                totalLength += allFile.length();
            }
            btnDelete.getScene().getWindow();
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    double write = 0.0;
                    for (File allFile : allFiles) {
                        File tempFileToDeleteFolder = File.createTempFile("file","deleteFolder");
                        FileInputStream fis = new FileInputStream(allFile);
                        FileOutputStream fos = new FileOutputStream(tempFileToDeleteFolder);
                        while (true){
                            byte[] buffer = new byte[1024];
                            int read = fis.read(buffer);
                            if (read == -1) break;
                            fos.write(buffer,0,read);
                            write += read;
                            updateMessage(String.format("%2.2f",((write * 100.0)/totalLength)).concat("% Deleted"));
                            updateProgress(write,totalLength);
                        }
                        fis.close();
                        fos.close();
                    }
                    FileUtils.deleteDirectory(srcFile);
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
        }
    }

    @FXML
    void btnMoveOnAction(ActionEvent event) throws IOException {
        if (srcFile.isFile()){
            if (targetFile.exists()){
                Optional<ButtonType> optResult = new Alert(Alert.AlertType.CONFIRMATION,"File already exists, are you sure to replace the file...?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (optResult.isEmpty() || optResult.get() == ButtonType.NO) return;
            }
            btnMove.getScene().getWindow();
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    FileInputStream fis = new FileInputStream(srcFile);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    double write = 0.0;
                    while (true){
                        byte[] buffer = new byte[1024];
                        int read = fis.read(buffer);
                        if (read == -1) break;
                        fos.write(buffer,0,read);
                        write += read;
                        updateMessage(String.format("%2.2f",((write * 100.0)/srcFile.length())).concat("% Moved"));
                        updateProgress(write,srcFile.length());
                    }
                    srcFile.delete();
                    fis.close();
                    fos.close();
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
        }
        if (srcFile.isDirectory()){
            findFiles(srcFile);
            for (File allFile : allFiles) {
                totalLength += allFile.length();
            }
            if (targetFile.exists()){
                Optional<ButtonType> optResult = new Alert(Alert.AlertType.CONFIRMATION,"File already exists, are you sure to replace the file...?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (optResult.isEmpty() || optResult.get() == ButtonType.NO) return;
            }
            btnCopy.getScene().getWindow();
            FileUtils.copyDirectory(srcFile,targetFile);
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    double write = 0.0;
                    for (File allFile : allFiles) {
                        File tempFileToCopyFolder = File.createTempFile("file","copyFolder");
                        FileInputStream fis = new FileInputStream(allFile);
                        FileOutputStream fos = new FileOutputStream(tempFileToCopyFolder);
                        while (true){
                            byte[] buffer = new byte[1024];
                            int read = fis.read(buffer);
                            if (read == -1) break;
                            fos.write(buffer,0,read);
                            write += read;
                            updateMessage(String.format("%2.2f",((write * 100.0)/totalLength)).concat("% Moved"));
                            updateProgress(write,totalLength);
                        }
                        tempFileToCopyFolder.delete();
                        fis.close();
                        fos.close();
                    }
                    FileUtils.deleteDirectory(srcFile);
                    return null;
                }
            };
            new Thread(task).start();
            txtPrg.textProperty().bind(task.messageProperty());
            prg.progressProperty().bind(task.progressProperty());
        }
    }
    private void findFiles(File path){
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                findFiles(file);
                continue;
            }
            allFiles.add(file);
        }
    }
}

