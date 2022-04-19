package com.sda;

public class HourlyEmployee extends CompanyMembers{
    int hoursWorked;
    int payRate;
    public HourlyEmployee(String firstName, String lastName, String phone,int hoursWorked,int payRate) {
        super(firstName, lastName, phone);
        this.hoursWorked=hoursWorked;
        this.payRate=payRate;
    }
    @Override
    public int plata() {
        System.out.println(this.payRate*this.hoursWorked);
        return this.payRate*this.hoursWorked;
    }
}
