package org.example;

public class AdresBuitenlandFactory implements AdresFactory {

    @Override
    public Adres createAdres(String straat, String huisnummer, String postcode, String stad, String land) {
        return new AdresBuitenland(straat, huisnummer, postcode, stad, land);
    }
}