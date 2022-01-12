package controller;

import Model.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddCustomerController {
    public TextField textAddress;
    public TextField txtNICNumber;
    public TextField txtContactNumber;
    public TextField txtCity;
    public TextField txtFullyName;
    public TextField txtCustomerId;

    public void RegesterOnAction(ActionEvent actionEvent) {
        ArrayList<Customer> customerData=new ArrayList();
        customerData.add(new Customer(txtCustomerId.getText(),txtFullyName.getText(),Integer.valueOf(txtContactNumber.getText()),textAddress.getText()));
        try {

            if (CustomerController.registerCustomer(customerData)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Added.").show();
                clearAll();
            }else new Alert(Alert.AlertType.WARNING,"Customer Added Faill.").show();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearAll() {
        textAddress.clear();
        txtContactNumber.clear();
        txtCustomerId.clear();
        txtFullyName.clear();
        txtCity.clear();
        txtNICNumber.clear();
    }
}
