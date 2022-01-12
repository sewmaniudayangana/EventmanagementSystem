package controller;

import Model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRegisterFormController {
    public TextField txtEmployeeId;
    public TextField txtEmployeeName;
    public TextField txtEmployeeAddress;
    public TextField txtEmployeeContact;

    public void registerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> empData=new ArrayList();
        empData.add(new Employee(
                txtEmployeeId.getText(),txtEmployeeName.getText(),txtEmployeeAddress.getText(),Integer.parseInt(txtEmployeeContact.getText())
        ));
        if (EmployeeController.registerEmployee(empData)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Successful").show();
            clearAll();
        }else{
            new Alert(Alert.AlertType.WARNING,"Unsuccessful").show();
            clearAll();
        }
    }

    private void clearAll() {
        txtEmployeeId.clear();
        txtEmployeeContact.clear();
        txtEmployeeAddress.clear();
        txtEmployeeName.clear();
    }
}