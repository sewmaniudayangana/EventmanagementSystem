package controller;

import Model.Payment;
import Model.Report;
import db.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportController {

    public static ArrayList<Payment> getDaliIncomeReportData() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT date,sum(pay_Amount) as pay_Amount from payment group by date order by pay_Amount desc ").executeQuery();
        ArrayList<Payment> temp=new ArrayList();
        while (rst.next()) {
            temp.add(new Payment(rst.getDouble(2), rst.getDate(1)));
        }
        return temp;
    }

    public static ArrayList<Report> getMonthlyIncomeInService() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT extract(MONTH FROM (date)),sum(pay_Amount) FROM payment GROUP BY extract(MONTH FROM (date)) ").executeQuery();
        ArrayList<Report> temp=new ArrayList();
        while (rst.next()){
            int monthNumber=rst.getInt(1);
            Double sumOfTotal= rst.getDouble(2);
            String month=selectMonth(monthNumber);
            temp.add(new Report(
                    month,sumOfTotal
            ));
        }
        return temp;
    }

    private static String selectMonth(int monthNumber) {
        if (monthNumber==1){
            return "January";
        }else if (monthNumber==2){
            return "February";
        }else if (monthNumber==3){
            return "March";
        }else if (monthNumber==4){
            return "April";
        }else if (monthNumber==5){
            return "May";
        }else if (monthNumber==6){
            return "June";
        }else if (monthNumber==7){
            return "July";
        }else if (monthNumber==8){
            return "August";
        }else if (monthNumber==9){
            return "September";
        }else if (monthNumber==10){
            return "October";
        }else if (monthNumber==11){
            return "November";
        }else {
            return "December";
        }


    }
}
