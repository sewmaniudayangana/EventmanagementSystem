package controller;

import Model.Booking;
import db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingController {

    public static String loadBookingId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT b_Id FROM booking order by b_Id DESC LIMIT 1").executeQuery();
        if (rst.next()){
            int tempId=Integer.parseInt(rst.getString(1).split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "B-00"+tempId;
            }else if (tempId<=99){
                return "B-0"+tempId;
            }else {
                return "B-"+tempId;
            }
        }else {
            return "B-001";
        }
    }


    public static boolean saveBookingDetails(ArrayList<Booking> bookingDetails, String bookingType) throws SQLException, ClassNotFoundException {
        Connection con=null;
        try {
            con=DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement stm =con.prepareStatement("INSERT  INTO booking values(?,?,?,?,?) ");
            for (Booking temp:bookingDetails
             ) {
                stm.setString(1, temp.getBookingId());
                stm.setString(2, temp.getCstId());
                stm.setString(3, temp.getBookingType());
                stm.setInt(4,temp.getNumberOfPlate());
                stm.setString(5, temp.getPlace());
                if (stm.executeUpdate()>0) {
                    if (fillBookingDetails(temp.getBookingType(),temp.getBookingId(),temp.getCstId())){
                        con.commit();
                        return true;
                    }else {
                        con.rollback();
                        return false;
                    }
                }else {
                    con.rollback();
                    return false;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    private static boolean fillBookingDetails(String bookingType, String bookingId, String cst_Id) throws SQLException, ClassNotFoundException {
        String ev_Id="None";
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT ev_Id FROM event where ev_Type=?");
        stm.setString(1,bookingType);
        ResultSet rst = stm.executeQuery();
        if (rst.next()){
            ev_Id=rst.getString(1);
        }else {
            return false;
        }
        System.out.println(bookingId);
        System.out.println(ev_Id);
        System.out.println(cst_Id);
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO eventmanagement.booking_detail values (?,?,?)");
        statement.setString(1,bookingId);
        statement.setString(2,ev_Id);
        statement.setString(3,cst_Id);
        return statement.executeUpdate()>0;
    }

    public static ArrayList<String> loadCustomerId() throws SQLException, ClassNotFoundException {
        ArrayList<String> customerId=new ArrayList();
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT cu_id From customer").executeQuery();
        while (rst.next()) {
            customerId.add(rst.getString(1));
        }
        return customerId;
    }
}
