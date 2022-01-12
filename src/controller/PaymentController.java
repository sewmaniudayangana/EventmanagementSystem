package controller;

import Model.Payment;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PaymentController {
    public static String loadPaymentId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT pay_Id FROM payment order by pay_Id DESC LIMIT 1").executeQuery();
        if (rst.next()){
            int tempId=Integer.parseInt(rst.getString(1).split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "P-00"+tempId;
            }else if (tempId<=99){
                return "P-0"+tempId;
            }else {
                return "P-"+tempId;
            }
        }else {
            return "P-001";
        }
    }

    public static boolean pay(ArrayList<Payment> paymentDetails, Date date) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT  INTO payment values (?,?,?,?)");
        for (Payment temp:paymentDetails
             ) {
            stm.setString(1, temp.getPay_Id());
            stm.setDouble(2,temp.getTotal_Payment());
            stm.setDouble(3,temp.getSpecial());
            stm.setObject(4, date);
            return stm.executeUpdate()>0;
        }
        return false;
    }
}
