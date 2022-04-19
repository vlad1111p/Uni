package com.sda;

public class Volunteer extends CompanyMembers{

    public Volunteer(String firstName, String lastName, String phone) {
        super(firstName, lastName, phone);
    }
    @Override
    public int plata() {
        System.out.println("0");
        return 0;
    }

}
