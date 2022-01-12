package controller;

import Model.Payment;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class PaymentDetailController {


    public TextField txtOtherExpenses;
    public TextField txtDecoration;
    public TextField txtDepositPaid;
    public TextField txtBalance;
    public Label lblAmount;
    public Label lblPaymentId;
    public Label lblBalance;
    public Label lblDepositPaid;
    public TextField txtPlatePrice;
    public TextField txtTotalPlate;
    public Label lblDate;
    public Label lblTime;
    double total=0;
    public void initialize(){
        loadDateTime();
        try {

            loadPaymentId();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadDateTime() {
        Date date=new Date();
        SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd ");
        lblDate.setText(f.format(date));

        Timeline time=new Timeline(new KeyFrame(Duration.ZERO, event -> {
            LocalTime currentTime= LocalTime.now();
            lblTime.setText(
                    currentTime.getHour()+" : "+currentTime.getMinute()+
                            " : "+currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void loadPaymentId() throws SQLException, ClassNotFoundException {
        lblPaymentId.setText(PaymentController.loadPaymentId());
    }

    public void payOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Date date=new Date();
        ArrayList<Payment> paymentDetails=new ArrayList();
        paymentDetails.add(new Payment(
                lblPaymentId.getText(),total,Double.valueOf(txtPlatePrice.getText())
        ));
        if (PaymentController.pay(paymentDetails,date)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Successful").show();
            clearAll();
            loadPaymentId();
        }else {new Alert(Alert.AlertType.WARNING,"Error").show();}
    }

    private void clearAll() {
        txtBalance.clear();
        txtDepositPaid.clear();
        txtDecoration.clear();
        txtPlatePrice.clear();
        txtTotalPlate.clear();
        txtOtherExpenses.clear();
        lblBalance.setVisible(false);
        lblDepositPaid.setVisible(false);
        txtBalance.setVisible(false);
        txtDepositPaid.setVisible(false);
    }


    public void calculateTotal(KeyEvent keyEvent) {
        if (keyEvent.getCode()== KeyCode.ENTER){
            lblDepositPaid.setVisible(true);
            txtDepositPaid.setVisible(true);
            total=(Double.valueOf(txtTotalPlate.getText())*Double.valueOf(txtPlatePrice.getText())+Double.valueOf(txtDecoration.getText())+Double.valueOf(txtOtherExpenses.getText()));
        }
        lblAmount.setText(total+"0 /=");
    }

    public void crateBalanceOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            lblBalance.setVisible(true);
            txtBalance.setVisible(true);
            txtBalance.setText(Double.valueOf(txtDepositPaid.getText())-total+"0 /=");
        }
    }
}
