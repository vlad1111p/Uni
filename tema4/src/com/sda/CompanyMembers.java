package com.sda;

public abstract class CompanyMembers {

    String firstName;
    String lastName;
    String phone;

    public CompanyMembers(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    abstract int plata();
}
