package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainViewController {

    @FXML
    private Button btnRun;

    @FXML
    private Label lblStatus;

    @FXML
    private ProgressBar prg;

    @FXML
    void btnRunOnAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < 1000; i++) {
                    //System.out.println(i);
                    Thread.sleep(50);
                    double progress = i / 1000.0;
                    updateProgress(i,1000.0);
                    updateMessage(String.format("%.2f",(i / 1000.0 * 100)) + "% Complete");
                }
                System.out.println(Thread.currentThread().getName());
                return null;
            }
        };
        new Thread(task).start();

        prg.progressProperty().bind(task.progressProperty());
        lblStatus.textProperty().bind(task.messageProperty());

        //lblStatus.setText(progress + "% Complete");
        //prg.setProgress(progress);
    }

}

