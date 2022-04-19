package com.sda;

public class Room {
    String type;
    String booked;
    int number;
    Person person;

    public Room(String type, String booked, int number, Person person) {
        if (type == "single" || type == "double")
            this.type = type;

        this.booked = booked;
        this.number = number;
        this.person = person;
    }

    public Room(int number) {


        this.booked = "nerezervata";
        this.number = number;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == "single" || type == "double")
            this.type = type;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        if (booked == "rezervata" || booked == "nerezervata")
            this.booked = booked;
        else
            this.booked = "nerezervata";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", booked='" + booked + '\'' +
                ", number=" + number +

                '}';
    }
}
