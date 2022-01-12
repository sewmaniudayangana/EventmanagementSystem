package controller;

import Model.Employee;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController {
    public static boolean registerEmployee(ArrayList<Employee> empData) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO employee values (?,?,?,?)");
        for (Employee temp:empData
             ) {
            stm.setString(1,temp.getEmpId());
            stm.setString(2,temp.getEmpName());
            stm.setString(3,temp.getEmpAddress());
            stm.setInt(4,temp.getEmpContact());
            return stm.executeUpdate()>0;
        }
        return false;
    }

    public static ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException {
        ArrayList<String> employeeId=new ArrayList();
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT e_Id From employee").executeQuery();
        while (rst.next()) {
            employeeId.add(rst.getString(1));
        }
        return employeeId;
    }

    public static ArrayList<Employee> getEmployeeData(String empId) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * from employee where e_Id=?");
        stm.setString(1,empId);
        ResultSet rst = stm.executeQuery();
        ArrayList<Employee> temp=new ArrayList();
        if (rst.next()) {
            temp.add(new Employee(
                    rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)
            ));
        }
        return temp;
    }

    public static boolean updateEmployee(ArrayList<Employee> employee) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE employee SET e_Name=?,e_Address=?,e_Contact=? where e_Id=?");
        for (Employee tmp:employee
             ) {
           stm.setString(1,tmp.getEmpName());
           stm.setString(2,tmp.getEmpAddress());
           stm.setInt(3,tmp.getEmpContact());
           stm.setString(4,tmp.getEmpId());
           return stm.executeUpdate()>0;
        }
        return false;
    }

    public static boolean deleteEmployee(String empId) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM employee WHERE e_Id=?");
        stm.setString(1,empId);
        return stm.executeUpdate()>0;
    }

    public static ArrayList<Employee> loadEmployeeData() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM employee").executeQuery();
        ArrayList<Employee> temp=new ArrayList();
        while (rst.next()) {
            temp.add(new Employee(
                    rst.getString(1), rst.getString(2), rst.getNString(3), rst.getInt(4)
            ));
        }
        return temp;
    }
}
