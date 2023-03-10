package lk.ijse.dep10.regexp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private ArrayList<Integer> startIndexes = new ArrayList<>();
    private int pos = 0;
    private int startPos = 0;

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
        startIndexes.clear();
        pos = 0;
        txtEditor.deselect();
        Pattern pattern;
        try {
            if (chkMatchCase.isSelected()){
                pattern = Pattern.compile(query);
            }
            else {
                pattern = Pattern.compile(query,Pattern.CASE_INSENSITIVE);
            }
        }
        catch (RuntimeException e){
            return;
        }
        Matcher matcher = pattern.matcher(txtEditor.getText());
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            SearchResults result = new SearchResults(start, end);
            startIndexes.add(start);
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

    @FXML
    void btnDownOnAction(ActionEvent event) {
        pos++;
        startPos++;
        if (pos == searchResults.size()){
            pos = -1;
            startPos = -1;
            return;
        }
        select();
    }

    @FXML
    void btnReplaceAllOnAction(ActionEvent event) {
        String findText = txtFind.getText();
        String replaceText = txtReplace.getText();

        if (txtFind.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Please input something to the find text").show();
            return;
        }

        if (txtReplace.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Please input something to the replace text").show();
            return;
        }

        String newText = txtEditor.getText().replaceAll(findText,replaceText);
        txtEditor.setText(newText);
    }

    @FXML
    void btnReplaceOnAction(ActionEvent event) {

        if (txtFind.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Please input something to the find text").show();
            return;
        }

        if (txtReplace.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Please input something to the replace text").show();
            return;
        }

        if (startIndexes.get(startPos) != 0){
            String firstPart = txtEditor.getText().substring(0,startIndexes.get(startPos));
            String secondPart = txtEditor.getText().substring(startIndexes.get(startPos));
            String newSecondPart = secondPart.replaceFirst(txtEditor.getSelectedText(),txtReplace.getText());
            String finalString = firstPart + newSecondPart;
            txtEditor.setText(finalString);
        }
        if (startIndexes.get(startPos) == 0){
            String finalString = txtEditor.getText().replaceFirst(txtEditor.getSelectedText(),txtReplace.getText());
            txtEditor.setText(finalString);
        }

    }

    @FXML
    void btnUpOnAction(ActionEvent event) {
        pos--;
        startPos--;
        if (pos < 0){
            pos = searchResults.size();
            startPos = startIndexes.size();
            return;
        }
        select();
    }

    @FXML
    void chkMatchCaseOnAction(ActionEvent event) {
        if (txtFind.getText().isBlank()){
            lblResults.setText("0 Results");
        }
        else {
            calculateSearchResult();
        }
    }

}
