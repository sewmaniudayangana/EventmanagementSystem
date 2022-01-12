package controller;

import Model.Booking;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class BookingDetailFormController {
    public TextField txtStartTime;
    public TextField txtEndTime;
    public DatePicker calendarPreferredEvent;
    public ComboBox cmbPlace;
    public TextField txtPlate;
    public ComboBox cmbBookingType;
    public Label lblBookId;
    public ComboBox cmbCustomerId;
    public Label lblDate;
    public Label lblTime;

    public void initialize(){
       loadTimeAndDate();
        try {

            loadBookingId();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        loadPlaces();

        try {

            loadCustomerId();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        loadBookingType();
    }

    private void loadTimeAndDate() {
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

    private void loadCustomerId() throws SQLException, ClassNotFoundException {
        ArrayList<String> customerId= BookingController.loadCustomerId();
        cmbCustomerId.getItems().addAll(customerId);
    }

    private void loadBookingType() {
        ArrayList<String> bookingType=new ArrayList();
        bookingType.add("Birthday Party");
        bookingType.add("Wedding");
        bookingType.add("Special Party");
        cmbBookingType.getItems().addAll(bookingType);
    }

    private void loadPlaces() {
        ArrayList<String> place=new ArrayList();
        place.add("Outdoor");
        place.add("Indoor");
        cmbPlace.getItems().addAll(place);
    }

    private void loadBookingId() throws SQLException, ClassNotFoundException {
       String bookingId= BookingController.loadBookingId();
       lblBookId.setText(bookingId);
    }

    public void save(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<Booking> bookingDetails=new ArrayList();
       String bookingType=(String) cmbBookingType.getValue();
       String place=(String) cmbPlace.getValue();
        bookingDetails.add(new Booking(
                lblBookId.getText(),(String) cmbCustomerId.getValue(),bookingType,Integer.valueOf(txtPlate.getText()),place
        ));
        if (BookingController.saveBookingDetails(bookingDetails,bookingType)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Successful").show();
            clearAll();
            loadBookingId();
        }else new Alert(Alert.AlertType.WARNING,"Unsuccessful").show();
    }

    private void clearAll() {
        txtPlate.clear();
        txtEndTime.clear();
        txtStartTime.clear();
    }


}
