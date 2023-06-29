package org.example;

public class AdresNederlandFactory implements AdresFactory {

    @Override
    public Adres createAdres(String straat, String huisnummer, String postcode, String stad, String land) {
        return new AdresNederland(straat, huisnummer, postcode, stad);
    }
}