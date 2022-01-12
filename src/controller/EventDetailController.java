package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class EventDetailController {
    public AnchorPane changeAnchorPane;
    public TextField txtEnterNumber;

    public void EnterEventNumber(ActionEvent actionEvent) throws IOException {

    }

    public void EnterNumber(KeyEvent keyEvent) throws IOException {
      if ("1".equals(txtEnterNumber.getText())) {
          URL resource = getClass().getResource("../View/Wedding.fxml");
          Parent load = FXMLLoader.load(resource);
          changeAnchorPane.getChildren().clear();
          changeAnchorPane.getChildren().add(load);
      }else if ("2".equals(txtEnterNumber.getText())){
          URL resource = getClass().getResource("../View/BirthdayParty.fxml");
          Parent load = FXMLLoader.load(resource);
          changeAnchorPane.getChildren().clear();
          changeAnchorPane.getChildren().add(load);
      }else if("3".equals(txtEnterNumber.getText())){
          URL resource = getClass().getResource("../view/SpecialCelebreting.fxml");
          Parent load = FXMLLoader.load(resource);
          changeAnchorPane.getChildren().clear();
          changeAnchorPane.getChildren().add(load);
      }


    }
}
