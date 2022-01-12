package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBordController {
    public AnchorPane DashBord;
    public AnchorPane ChangeContext;

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddCustomer.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void bookingDetailOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/BookingDetailForm.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void EventManageOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/EventDetail.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void paymentDetailOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/PaymentDetail.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene;
        scene = new Scene(load);
        Stage window=(Stage) DashBord.getScene().getWindow();
        window.setScene(scene);
    }
}
