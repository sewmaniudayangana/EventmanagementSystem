package controller;

import Model.Customer;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {

    public static boolean registerCustomer(ArrayList<Customer> customerData) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO customer values(?,?,?,?)");
        for (Customer temp:customerData
             ) {
            stm.setString(1,temp.getCstId());
            stm.setString(2,temp.getCstName());
            stm.setString(3,temp.getAddress());
            stm.setInt(4,temp.getContactNumber());
            return stm.executeUpdate()>0;
        }

        return false;
    }
}
