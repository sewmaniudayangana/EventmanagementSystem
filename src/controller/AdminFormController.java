package controller;

import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminFormController {
    public AnchorPane changeAnchorPane;
    public AnchorPane adminContext;
    public TableView tblEmployeeDetails;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("empContact"));

        try {
            loadEmployeeData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeData() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees = EmployeeController.loadEmployeeData();
        tblEmployeeDetails.getItems().addAll(employees);
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EmployeeRegisterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }



    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) adminContext.getScene().getWindow();
        window.setScene(scene);
    }


    public void employeeRemoveOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DeleteForm.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }

    public void employeeUpdateOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EmployeeUpdate.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }

    public void dalyInComeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DalyIncomeReport.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }

    public void monthlyInComeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MonthlyIncomeReport.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }

    public void employeeDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EmployeeDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        changeAnchorPane.getChildren().clear();
        changeAnchorPane.getChildren().add(load);
    }
}