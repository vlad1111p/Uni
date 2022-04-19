package com.sda;

public class Executive extends CompanyMembers{
    int payRate;
    int Bonus;
    public Executive(String firstName, String lastName, String phone,int payRate,int Bonus) {
        super(firstName, lastName, phone);
        this.payRate=payRate;
        this.Bonus=Bonus;
    }
    @Override
    public int plata() {
        System.out.println(this.payRate+this.payRate);
        return this.payRate+this.payRate;
    }
}
