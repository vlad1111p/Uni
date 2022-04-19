package com.sda;

import java.util.ArrayList;

public class Company {

    ArrayList<CompanyMembers> arrayofworkers= new ArrayList<CompanyMembers>();

    public ArrayList<CompanyMembers> getArrayofworkers() {
        return arrayofworkers;
    }

    public void addWorkers(CompanyMembers worker) {
        this.arrayofworkers.add(worker);
    }
    public void displayWorkers(){
        for (CompanyMembers obj: this.arrayofworkers){
            System.out.println(obj.firstName+" "+obj.lastName+" "+obj.phone);
        }
    }
}
