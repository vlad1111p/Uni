package com.sda;

public class SalesEmployee extends CompanyMembers{
    int payRate;
    int numberOfSales;
    double comissionRate;

    public SalesEmployee(String firstName, String lastName, String phone, int payRate, int numberOfSales, double comissionRate) {
        super(firstName, lastName, phone);
        this.payRate = payRate;
        this.numberOfSales = numberOfSales;
        this.comissionRate = comissionRate;
    }
    @Override
    public int plata() {
        System.out.println((this.payRate%this.comissionRate)*this.numberOfSales);
        return (int) (this.payRate%this.comissionRate)*this.numberOfSales;
    }
}
