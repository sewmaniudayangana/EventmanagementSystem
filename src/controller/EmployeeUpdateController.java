package controller;

import Model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeUpdateController {


    public TextField txtEmployeeName;
    public TextField txtEmployeeAddress;
    public TextField txtEmployeeContact;
    public ComboBox cmbEmpId;


    public void initialize(){
        try {
            loadEmployeeId();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeId() throws SQLException, ClassNotFoundException {
        ArrayList<String> employee = EmployeeController.loadEmployeeId();
        cmbEmpId.getItems().addAll(employee);
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employee=new ArrayList();
        employee.add(new Employee(
                (String) cmbEmpId.getValue(),txtEmployeeName.getText(),txtEmployeeAddress.getText(),Integer.parseInt(txtEmployeeContact.getText())
        ));
        if (EmployeeController.updateEmployee(employee)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Successful").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Error").show();

        }
        clearAll();
    }

    public void loadEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employeeData = EmployeeController.getEmployeeData((String) cmbEmpId.getValue());
        for (Employee temp:employeeData
             ) {
            txtEmployeeName.setText(temp.getEmpName());
            txtEmployeeAddress.setText(temp.getEmpAddress());
            txtEmployeeContact.setText(String.valueOf(temp.getEmpContact()));
        }
    }
    private void clearAll() {
        txtEmployeeContact.clear();
        txtEmployeeAddress.clear();
        txtEmployeeName.clear();
    }
}