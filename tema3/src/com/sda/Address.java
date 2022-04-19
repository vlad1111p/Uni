package com.sda;

public class Address {
    String adresa;
    String oras;
    String tara;
    String coordonategeografice;

    public Address(String adresa, String oras, String tara, String coordonategeografice) {
        this.adresa = adresa;
        this.oras = oras;
        this.tara = tara;
        this.coordonategeografice = coordonategeografice;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getCoordonategeografice() {
        return coordonategeografice;
    }

    public void setCoordonategeografice(String coordonategeografice) {
        this.coordonategeografice = coordonategeografice;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adresa='" + adresa + '\'' +
                ", oras='" + oras + '\'' +
                ", tara='" + tara + '\'' +
                ", coordonategeografice='" + coordonategeografice + '\'' +
                '}';
    }
}
