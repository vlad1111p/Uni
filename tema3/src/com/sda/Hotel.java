package com.sda;

import java.util.ArrayList;

public class Hotel {
    Address adresa;
    ArrayList<Room> Rooms;
    ArrayList<Person> bookedpersons = new ArrayList<>();
    String name;


    public Hotel(Address adresa, String name) {
        this.adresa = adresa;
        this.name = name;
    }

    public void bookRoom(int number, Person p) {
        for (Room room : Rooms) {
            if (room.getNumber() == number) {
                room.setBooked("rezervata");
                room.setPerson(p);
            }
        }
        bookedpersons.add(p);
    }

    public void displaypersons() {
        for (Person person : bookedpersons)
            System.out.println(person.toString());
    }

    public Address getAdresa() {
        return adresa;
    }

    public void setAdresa(Address adresa) {
        this.adresa = adresa;
    }

    public ArrayList<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        Rooms = rooms;
    }

    public ArrayList<Person> getBookedpersons() {
        return bookedpersons;
    }

    public void setBookedpersons(ArrayList<Person> bookedpersons) {
        this.bookedpersons = bookedpersons;
    }

    public ArrayList<Room> returnCamereNerezervate() {
        ArrayList<Room> camerenerezervate = new ArrayList<>();
        for (Room room : Rooms) {
            if (room.getBooked() != "rezervata")
                camerenerezervate.add(room);
        }
        return camerenerezervate;
    }

    public void displayCamereNerezervate() {
        ArrayList<Room> camerenerezervate = returnCamereNerezervate();
        for (Room room : camerenerezervate) {
            System.out.println(room.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "adresa=" + adresa +


                ", name='" + name + '\'' +
                '}';
    }
}

