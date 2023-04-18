package org.example;

public class VerzendEtiket {
    private Adres adres;

    public VerzendEtiket(Adres adres) {
        this.adres = adres;
    }
    public String genereerEtiket() {
        String etiket = "Verzendadres:\n" +
                adres.getAdres() + "\n";
        return etiket;
    }
}
