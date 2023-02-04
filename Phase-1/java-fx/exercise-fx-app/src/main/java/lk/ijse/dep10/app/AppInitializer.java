package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage mainStage = new Stage();
        Label mainTitle = new Label("FX Containers");
        mainTitle.setFont(Font.font(25));

        Button anchorPaneButton = new Button("Anchor Pane");
        anchorPaneButton.setMinWidth(130);
        anchorPaneButton.setOnAction(event -> {
            anchorPaneButton();
        });
        Button flowPaneButton = new Button("Flow Pane");
        flowPaneButton.setMinWidth(130);
        flowPaneButton.setOnAction(event -> {
            flowPaneButton();
        });
        Button tilePaneButton = new Button("Tile Pane");
        tilePaneButton.setMinWidth(130);
        tilePaneButton.setOnAction(event -> {
            tilePaneButton();
        });
        Button stackPaneButton = new Button("Stack Pane");
        stackPaneButton.setMinWidth(130);
        stackPaneButton.setOnAction(event -> {
            stackPaneButton();
        });
        Button borderPaneButton = new Button("Border Pane");
        borderPaneButton.setMinWidth(130);
        borderPaneButton.setOnAction(event -> {
            borderPaneButton();
        });
        Button gridPaneButton = new Button("Grid Pane");
        gridPaneButton.setMinWidth(130);
        gridPaneButton.setOnAction(event -> {
            gridPaneButton();
        });
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
        container.add(borderPaneButton,0,5);
        container.add(gridPaneButton,0,6);
        container.add(hBoxButton,0,7);
        container.add(vBoxButton,0,8);
        container.setVgap(12);
        container.setPadding(new Insets(25,25,25,25));
        container.setGridLinesVisible(false);

        GridPane.setHalignment(mainTitle, HPos.CENTER);
        GridPane.setHalignment(anchorPaneButton, HPos.CENTER);
        GridPane.setHalignment(flowPaneButton, HPos.CENTER);
        GridPane.setHalignment(tilePaneButton, HPos.CENTER);
        GridPane.setHalignment(stackPaneButton, HPos.CENTER);
        GridPane.setHalignment(borderPaneButton, HPos.CENTER);
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
    private void anchorPaneButton(){
        Stage anchorPaneStage = new Stage();
        anchorPaneStage.setTitle("AnchorPane Button");
        anchorPaneStage.setWidth(400);
        anchorPaneStage.setHeight(400);

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        AnchorPane anchorPaneContainer = new AnchorPane();
        anchorPaneContainer.setPadding(new Insets(20));
        int xPosition = 20;
        int yPosition = 20;
        for (int i = 0; i < buttons.length; i++) {
            anchorPaneContainer.getChildren().add(buttons[i]);
            buttons[i].setLayoutX(xPosition);
            buttons[i].setLayoutY(yPosition);
            xPosition += 74;
            yPosition += 74;
        }
        Scene anchorPaneScene = new Scene(anchorPaneContainer);
        anchorPaneStage.setScene(anchorPaneScene);
        anchorPaneStage.setResizable(false);
        anchorPaneStage.show();
        anchorPaneStage.centerOnScreen();
    }
    private void flowPaneButton(){
        Stage flowPaneStage = new Stage();
        flowPaneStage.setTitle("FlowPane Button");
        flowPaneStage.setHeight(400);
        flowPaneStage.setWidth(400);

        Button[] buttons = new Button[5];
        FlowPane flowPaneContainer = new FlowPane();
        flowPaneContainer.setPadding(new Insets(20));
        flowPaneContainer.setHgap(15);
        flowPaneContainer.setVgap(15);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
            flowPaneContainer.getChildren().add(buttons[i]);
        }
        Scene anchorPaneScene = new Scene(flowPaneContainer);
        flowPaneStage.setScene(anchorPaneScene);
        flowPaneStage.show();
        flowPaneStage.centerOnScreen();

    }
    private void tilePaneButton(){
        Stage tilePaneStage = new Stage();
        tilePaneStage.setTitle("TilePane Button");
        tilePaneStage.setWidth(250);
        tilePaneStage.setHeight(250);

        Button[] buttons = new Button[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }

        TilePane tilePaneContainer = new TilePane();
        tilePaneContainer.setHgap(20);
        tilePaneContainer.setVgap(20);
        tilePaneContainer.setPadding(new Insets(20));
        for (int i = 0; i < buttons.length; i++) {
            tilePaneContainer.getChildren().add(buttons[i]);
        }

        Scene tilePaneScene = new Scene(tilePaneContainer);
        tilePaneStage.setScene(tilePaneScene);
        tilePaneStage.setResizable(false);
        tilePaneStage.show();
        tilePaneStage.centerOnScreen();
    }
    private void gridPaneButton(){
        Stage gridPaneStage = new Stage();
        gridPaneStage.setTitle("GridPane Button");
        gridPaneStage.setHeight(200);
        gridPaneStage.setWidth(200);
        gridPaneStage.setResizable(false);

        Button[] buttons = new Button[8];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        GridPane gridPaneContainer = new GridPane();
        gridPaneContainer.add(buttons[0],0,0);
        gridPaneContainer.add(buttons[1],0,1);
        gridPaneContainer.add(buttons[2],0,2);
        gridPaneContainer.add(buttons[3],0,3);
        gridPaneContainer.add(buttons[4],1,0);
        gridPaneContainer.add(buttons[5],1,1);
        gridPaneContainer.add(buttons[6],1,2);
        gridPaneContainer.add(buttons[7],1,3);

        gridPaneContainer.setHgap(10);
        gridPaneContainer.setVgap(10);
        gridPaneContainer.setPadding(new Insets(20));

        Scene gridPaneScene = new Scene(gridPaneContainer);
        gridPaneStage.setScene(gridPaneScene);
        gridPaneStage.show();
        gridPaneStage.centerOnScreen();
    }
    private void stackPaneButton(){
        Stage stackPaneStage = new Stage();
        stackPaneStage.setTitle("StackPane Stage");
        stackPaneStage.setHeight(250);
        stackPaneStage.setWidth(250);
        stackPaneStage.setResizable(false);

        Button[] buttons = new Button[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        StackPane stackPaneContainer = new StackPane();
        for (int i = 0; i < buttons.length; i++) {
            stackPaneContainer.getChildren().add(buttons[i]);
        }
        Scene stackPaneScene = new Scene(stackPaneContainer);
        stackPaneStage.setScene(stackPaneScene);
        stackPaneStage.show();
        stackPaneStage.centerOnScreen();
    }
    private void borderPaneButton(){
        Stage borderPaneStage = new Stage();
        borderPaneStage.setTitle("BorderPane Button");
        borderPaneStage.setHeight(300);
        borderPaneStage.setWidth(300);
        borderPaneStage.setResizable(false);

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }

        BorderPane borderPaneContainer = new BorderPane();
        borderPaneContainer.setPadding(new Insets(20));
        borderPaneContainer.setTop(buttons[0]);
        borderPaneContainer.setLeft(buttons[1]);
        borderPaneContainer.setRight(buttons[2]);
        borderPaneContainer.setBottom(buttons[3]);
        borderPaneContainer.setCenter(buttons[4]);

        Scene borderPaneScene = new Scene(borderPaneContainer);
        borderPaneStage.setScene(borderPaneScene);
        borderPaneStage.show();
        borderPaneStage.centerOnScreen();
    }
    private void hBoxButton(){
        Stage hBoxStage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i+1));
        }
        HBox hBoxContainer = new HBox(10,buttons);
        hBoxContainer.setPadding(new Insets(25));
        Scene hBoxScene = new Scene(hBoxContainer);

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
        VBox vBoxContainer = new VBox(10,buttons);
        vBoxContainer.setPadding(new Insets(20));
        vBoxContainer.setAlignment(Pos.BASELINE_CENTER);

        Scene vBoxScene = new Scene(vBoxContainer);
        vBoxStage.setScene(vBoxScene);
        vBoxStage.setResizable(false);
        vBoxStage.setHeight(250);
        vBoxStage.setWidth(250);
        vBoxStage.setTitle("VBox Button");
        vBoxStage.show();
        vBoxStage.centerOnScreen();
    }
}
