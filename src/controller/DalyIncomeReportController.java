package controller;

import Model.Payment;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.sql.SQLException;
import java.util.ArrayList;

public class DalyIncomeReportController {

    public AreaChart dalyIncome;

    public void initialize() {
        XYChart.Series series = new XYChart.Series();

        try {
            loadData(series);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dalyIncome.getData().add(series);
    }

    private void loadData(XYChart.Series series) throws SQLException, ClassNotFoundException {
        ArrayList<Payment> dalyIncomeData = ReportController.getDaliIncomeReportData();
        System.out.println(dalyIncomeData);
        for (Payment temp:dalyIncomeData
        ) {
           series.getData().add(new XYChart.Data(temp.getDate().toString(),temp.getTotal_Payment()));
        }
    }
}
