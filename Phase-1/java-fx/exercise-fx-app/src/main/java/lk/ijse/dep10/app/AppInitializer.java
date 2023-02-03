package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) { //ToDo
        Stage mainStage = new Stage();
        Label mainTitle = new Label("FX Containers");
        mainTitle.setFont(Font.font(25));

        Button anchorPaneButton = new Button("Anchor Pane");
        anchorPaneButton.setMinWidth(130);
        Button flowPaneButton = new Button("Flow Pane");
        flowPaneButton.setMinWidth(130);
        Button tilePaneButton = new Button("Tile Pane");
        tilePaneButton.setMinWidth(130);
        Button stackPaneButton = new Button("Stack Pane");
        stackPaneButton.setMinWidth(130);
        Button gridPaneButton = new Button("Grid Pane");
        gridPaneButton.setMinWidth(130);
        Button hBoxButton = new Button("hBox");
        hBoxButton.setMinWidth(130);
        hBoxButton.setOnAction(event -> {
            hBoxButton();
        });
        Button vBoxButton = new Button("vBox");
        vBoxButton.setMinWidth(130);
        vBoxButton.setOnAction(event -> {
            vBoxButton();
        });

        GridPane container = new GridPane();
        container.add(mainTitle,0,0);
        container.add(anchorPaneButton,0,1);
        container.add(flowPaneButton,0,2);
        container.add(tilePaneButton,0,3);
        container.add(stackPaneButton,0,4);
        container.add(gridPaneButton,0,5);
        container.add(hBoxButton,0,6);
        container.add(vBoxButton,0,7);
        container.setVgap(12);
        container.setPadding(new Insets(25,25,25,25));
        container.setGridLinesVisible(false);

        GridPane.setHalignment(mainTitle, HPos.CENTER);
        GridPane.setHalignment(anchorPaneButton, HPos.CENTER);
        GridPane.setHalignment(flowPaneButton, HPos.CENTER);
        GridPane.setHalignment(tilePaneButton, HPos.CENTER);
        GridPane.setHalignment(stackPaneButton, HPos.CENTER);
        GridPane.setHalignment(gridPaneButton, HPos.CENTER);
        GridPane.setHalignment(hBoxButton, HPos.CENTER);
        GridPane.setHalignment(vBoxButton, HPos.CENTER);

        Scene mainScene = new Scene(container);
        mainStage.setWidth(250);
        mainStage.setHeight(400);
        mainStage.setResizable(false);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Exercise");
        mainStage.show();
        mainStage.centerOnScreen();
    }
    private void hBoxButton(){
        Stage hBoxStage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        HBox hbox = new HBox(10,buttons);
        Scene hBoxScene = new Scene(hbox);

        hBoxStage.setScene(hBoxScene);
        hBoxStage.sizeToScene();
        hBoxStage.setResizable(false);
        hBoxStage.setTitle("HBox Button");
        hBoxStage.show();
        hBoxStage.centerOnScreen();
    }
    private void vBoxButton(){
        Stage vBoxStage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        VBox vbox = new VBox(10,buttons);
        //ToDo : Set alignment of the vbox buttons
        Scene vBoxScene = new Scene(vbox);
        vBoxStage.setScene(vBoxScene);
        vBoxStage.setHeight(200);
        vBoxStage.setWidth(250);
        vBoxStage.setTitle("VBox Button");
        vBoxStage.show();
        vBoxStage.centerOnScreen();
    }
}
