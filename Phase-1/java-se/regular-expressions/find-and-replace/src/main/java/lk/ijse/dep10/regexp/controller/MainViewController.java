package lk.ijse.dep10.regexp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.dep10.regexp.util.SearchResults;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainViewController {

    @FXML
    private Button btnDown;

    @FXML
    private Button btnReplace;

    @FXML
    private Button btnReplaceAll;

    @FXML
    private Button btnUp;

    @FXML
    private CheckBox chkMatchCase;

    @FXML
    private Label lblResults;

    @FXML
    private TextArea txtEditor;

    @FXML
    private TextField txtFind;

    @FXML
    private TextField txtReplace;
    private ArrayList<SearchResults> searchResults = new ArrayList<>();
    private int pos = 0;

    public void initialize(){
        txtFind.textProperty().addListener((ov, previous, current) -> {
            calculateSearchResult();
        });
        txtEditor.textProperty().addListener((ov, previous, current) -> {
            calculateSearchResult();
        });
    }
    private void calculateSearchResult(){
        String query = txtFind.getText();
        searchResults.clear();
        pos = 0;
        txtEditor.deselect();
        Pattern pattern;
        try {
            pattern = Pattern.compile(query);
        }
        catch (RuntimeException e){
            return;
        }
        Matcher matcher = pattern.matcher(txtEditor.getText());
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            SearchResults result = new SearchResults(start, end);
            searchResults.add(result);
        }
        lblResults.setText(String.format("%d Results",searchResults.size()));
        select();
    }
    private void select(){
        if (searchResults.isEmpty()) return;
        SearchResults searchResult = searchResults.get(pos);
        txtEditor.selectRange(searchResult.getStart(),searchResult.getEnd());
        lblResults.setText(String.format("%d/%d Results" ,(pos + 1),searchResults.size()));
    }
    private void searchWords(){

    }

    @FXML
    void btnDownOnAction(ActionEvent event) {
        pos++;
        if (pos == searchResults.size()){
            pos = -1;
            return;
        }
        select();
    }

    @FXML
    void btnReplaceAllOnAction(ActionEvent event) {

    }

    @FXML
    void btnReplaceOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpOnAction(ActionEvent event) {
        pos--;
        if (pos < 0){
            pos = searchResults.size();
            return;
        }
        select();
    }

    @FXML
    void chkMatchCaseOnAction(ActionEvent event) {

    }

}
