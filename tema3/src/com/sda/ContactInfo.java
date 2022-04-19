package com.sda;

public class ContactInfo {

    String email;
    String nrtelefon;

    public ContactInfo(String email, String nrtelefon) {
        this.email = email;
        this.nrtelefon = nrtelefon;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrtelefon() {
        return nrtelefon;
    }

    public void setNrtelefon(String nrtelefon) {
        this.nrtelefon = nrtelefon;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", nrtelefon='" + nrtelefon + '\'' +
                '}';
    }
}
