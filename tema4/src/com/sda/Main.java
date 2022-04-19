package com.sda;

public class Main {

    public static void main(String[] args) {


        Company Corporate=new Company();
        CompanyMembers newEmployee=new Employee("Andrei","bogdan","0744",22);
        Corporate.addWorkers(newEmployee);
        newEmployee.plata();
        Corporate.displayWorkers();
    }
}
