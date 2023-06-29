package org.example;

public interface AdresFactory {
    Adres createAdres(String straat, String huisnummer, String postcode, String stad, String land);
}