package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane HomePage;
    public AnchorPane LoginForm;
    public TextField txtUsername;
    public RadioButton redioManager;
    public RadioButton redoAdmin;
    public PasswordField Password;



    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if ("admin".equalsIgnoreCase(txtUsername.getText()) && redoAdmin.isSelected()&& Password.getText().equals("1234")){
            URL resource = getClass().getResource("../view/Admin.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene=new Scene(load);
            Stage window=(Stage) LoginForm.getScene().getWindow();
            window.setScene(scene);
        }else if ("manager".equalsIgnoreCase(txtUsername.getText())&& redioManager.isSelected() && Password.getText().equals("5678")){
            URL resource = getClass().getResource("../view/DashBord.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene=new Scene(load);
            Stage window=(Stage) LoginForm.getScene().getWindow();
            window.setScene(scene);
        }else {
            new Alert(Alert.AlertType.WARNING,"UserName or Password incorrect").show();
        }
    }
}
