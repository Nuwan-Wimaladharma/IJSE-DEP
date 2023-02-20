package lk.ijse.dep10.se.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.se.model.Item;

import java.math.BigDecimal;

public class MainSceneController {

    public Label lblProfit;
    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSellingPrice;

    public void initialize(){
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("profit"));
        tblItems.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItems.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("total"));
        tblItems.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("totalProfit"));

        btnNew.fire();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtCode.setText(generateNewItemCode());
        txtDescription.clear();
        txtSellingPrice.clear();
        txtBuyingPrice.clear();
        txtQty.clear();

        txtDescription.requestFocus();

        tblItems.getSelectionModel().clearSelection();
    }

    private String generateNewItemCode() {
        ObservableList<Item> itemList = tblItems.getItems();
        if (itemList.isEmpty()) return "I001";
        String lastItemCode = itemList.get(itemList.size() - 1).getCode();
        int newItemCode = Integer.parseInt(lastItemCode.substring(1)) + 1;
        return String.format("I%03d",newItemCode);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Item selectedItem = tblItems.getSelectionModel().getSelectedItem();
        ObservableList<Item> itemList = tblItems.getItems();
        if (selectedItem == null){
            Item item = new Item(txtCode.getText(),txtDescription.getText(),new BigDecimal(txtBuyingPrice.getText()),new BigDecimal(txtSellingPrice.getText()),Integer.parseInt(txtQty.getText()));
            itemList.add(item);
        }
        btnNew.fire();
        lblProfit.setText("Est. Total Profit: " + calculateEstimateProfit());
    }
    private String calculateEstimateProfit(){
        ObservableList<Item> itemList = tblItems.getItems();
        BigDecimal estimatedTotalProfit = BigDecimal.ZERO;
        for (Item item : itemList) {
            estimatedTotalProfit = estimatedTotalProfit.add(item.getTotalProfit());
        }
        return estimatedTotalProfit.setScale(2).toString();
    }

}

