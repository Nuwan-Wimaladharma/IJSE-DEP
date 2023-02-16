package lk.ijse.dep10.last.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.last.model.Employee;

import java.util.ArrayList;
import java.util.Optional;

public class TableViewSceneController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private TableView<Employee> tblEmployees;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize(){
        /* Column Mapping */
        tblEmployees.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployees.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployees.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<Employee> employeeList = tblEmployees.getItems();

        Employee e001 = new Employee("e001", "Nuwan Wimaladharma", "Melsiripura, Kurunegala");
        Employee e002 = new Employee("e002", "Gayashan Dananjaya", "Minuwangoda, Gampaha");
        Employee e003 = new Employee("e003", "Vipula Neranjava", "Keenawala, Gampaha");
        Employee e004 = new Employee("e004", "Sagara Pradeep", "Kaduwela, Colombo");

        employeeList.addAll(e001,e002,e003,e004);

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);

        tblEmployees.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            btnDelete.setDisable(current == null);

            if (current == null) return;

            txtId.setText(current.getId());
            txtName.setText(current.getName());
            txtAddress.setText(current.getId());
        });
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> optButton = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this employee", ButtonType.YES, ButtonType.NO).showAndWait();
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO) return;

        ObservableList<Employee> employeeList = tblEmployees.getItems();
        Employee selectdEmployee = tblEmployees.getSelectionModel().getSelectedItem();
        employeeList.remove(selectdEmployee);
        btnNew.fire();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        btnSave.setDisable(false);
        btnDelete.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();

        txtId.requestFocus();

        tblEmployees.getSelectionModel().clearSelection();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText().strip();
        String name = txtName.getText().strip();
        String address = txtAddress.getText().strip();

        for (TextField txt : new TextField[]{txtId, txtName, txtAddress}) {
            if (txt.getText().isBlank()){
                txt.selectAll();
                txt.requestFocus();
                return;
            }
        }
//        if (id.isBlank()){
//            txtId.selectAll();
//            txtId.requestFocus();
//            return;
//        }
//        if (name.isBlank()){
//            txtName.selectAll();
//            txtName.requestFocus();
//            return;
//        }
//        if (address.isBlank()){
//            txtAddress.selectAll();
//            txtAddress.requestFocus();
//            return;
//        }

        for (Employee employee : tblEmployees.getItems()) {
            if (employee.getId().equals(id)){
                txtId.selectAll();
                txtId.requestFocus();
                return;
            }
        }

        Employee selectedEmployee = tblEmployees.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null){ //add
            Employee employee = new Employee(id, name, address);
            tblEmployees.getItems().add(employee);
        }
        else {  //update
            selectedEmployee.setId(id);
            selectedEmployee.setName(name);
            selectedEmployee.setAddress(address);
        }
        btnNew.fire();
    }

}

