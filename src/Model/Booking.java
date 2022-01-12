package Model;

import db.DbConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class Booking {
    private String bookingId;
    private String cstId;
    private String bookingType;
    private int numberOfPlate;
    private String place;

    public Booking(String bookingId, String cstId, String bookingType, int numberOfPlate, String place) {
        this.setBookingId(bookingId);
        this.setCstId(cstId);
        this.setBookingType(bookingType);
        this.setNumberOfPlate(numberOfPlate);
        this.setPlace(place);
    }

    public Booking() {
    }



    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCstId() {
        return cstId;
    }

    public void setCstId(String cstId) {
        this.cstId = cstId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getNumberOfPlate() {
        return numberOfPlate;
    }

    public void setNumberOfPlate(int numberOfPlate) {
        this.numberOfPlate = numberOfPlate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", cstId='" + cstId + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", numberOfPlate=" + numberOfPlate +
                ", place='" + place + '\'' +
                '}';
    }
}
