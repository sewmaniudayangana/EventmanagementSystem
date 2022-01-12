package Model;

import java.util.Date;

public class Payment {
    private String pay_Id;
    private double total_Payment;
    private double special;
    private Date date;

    public Payment(double total_Payment, Date date) {
        this.total_Payment = total_Payment;
        this.setDate(date);
    }

    public Payment(String pay_Id, double total_Payment, double special) {
        this.pay_Id = pay_Id;
        this.total_Payment = total_Payment;
        this.special = special;
    }

    public Payment() {
    }


    public String getPay_Id() {
        return pay_Id;
    }

    public void setPay_Id(String pay_Id) {
        this.pay_Id = pay_Id;
    }

    public double getTotal_Payment() {
        return total_Payment;
    }

    public void setTotal_Payment(double total_Payment) {
        this.total_Payment = total_Payment;
    }

    public double getSpecial() {
        return special;
    }

    public void setSpecial(double special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pay_Id='" + pay_Id + '\'' +
                ", total_Payment=" + total_Payment +
                ", special=" + special +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
