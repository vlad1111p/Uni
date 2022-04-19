package com.sda;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Address adresa = new Address("Str. Cantemir nr.1", "Brasov", "Romania", "65,72");
        ArrayList<Room> listofrooms = new ArrayList<>();
        ContactInfo contactInfo = new ContactInfo("a@gmail.com", "0259");
        for (int i = 1; i <= 50; i++) {
            Room newroom = new Room(i);
            if (i % 2 == 0) {
                newroom.setType("single");
            } else {
                newroom.setType("double");
            }
            listofrooms.add(newroom);
        }
        Person person = new Person("Mihalea", "Vlad", contactInfo);
        Hotel hotel = new Hotel(adresa, "Hilton");
        hotel.setRooms(listofrooms);
        hotel.bookRoom(1, person);
        System.out.println("informatii despre hotel");
        System.out.println(hotel.toString());

        System.out.println("---------------------------------------------");
        System.out.println("informatii despre persoana");
        hotel.displaypersons();

        System.out.println("---------------------------------------------");
        System.out.println("Camere nerezervate");
        hotel.displayCamereNerezervate();


    }
}
