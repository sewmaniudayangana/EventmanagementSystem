package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class CostomerFormControler {
    public AnchorPane DashBord;
    public AnchorPane ChangeContext;

    public void AddCustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/AddCustomer.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void BookingDetail(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/BookingDetailForm.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void EventManage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/EventDetail.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }

    public void paymentDetail(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/PaymentDetail.fxml");
        Parent load = FXMLLoader.load(resource);
        ChangeContext.getChildren().clear();
        ChangeContext.getChildren().add(load);
    }
}
