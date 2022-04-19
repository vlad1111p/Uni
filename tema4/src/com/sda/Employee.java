package com.sda;

public class Employee extends CompanyMembers{
    int payRate;
    public Employee(String firstName, String lastName, String phone,int payRate) {
        super(firstName, lastName, phone);
        this.payRate=payRate;
    }

    @Override
    public int plata() {
        System.out.println(this.payRate);
        return this.payRate;
    }
}
