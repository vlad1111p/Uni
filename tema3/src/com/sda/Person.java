package com.sda;


public class Person {
    String nume;
    String prenume;
    ContactInfo contactInfo;

    public Person(String nume, String prenume, ContactInfo contactInfo) {
        this.nume = nume;
        this.prenume = prenume;
        this.contactInfo = contactInfo;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
