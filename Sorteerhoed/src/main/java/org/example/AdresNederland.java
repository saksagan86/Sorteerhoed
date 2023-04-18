package org.example;

public class AdresNederland extends Adres {

    public AdresNederland(String straat, String huisnummer, String postcode, String stad) {
        super(straat, huisnummer, postcode, stad);
    }

    @Override
    public String getAdres() {
        return straat + " " + huisnummer + ", " + postcode + " " + stad + ", Nederland";
    }

    @Override
    public String getLand() {
        return "Nederland";
    }
}
