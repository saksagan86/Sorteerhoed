package org.example;

public class Pakket {
    private String ontvanger;
    private String gewicht;
    private String trackingnummer;

    public void Pakket(String ontvanger, String gewicht, String trackingnummer){
        this.ontvanger = ontvanger;
        this.gewicht = gewicht;
        this.trackingnummer = trackingnummer;
    }

    public String getOntvanger() {
        return ontvanger;
    }

    public String getGewicht() {
        return gewicht;
    }

    public String getTrackingnummer() {
        return trackingnummer;
    }

    public void setOntvanger(String ontvanger) {
        this.ontvanger = ontvanger;
    }

    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    public void setTrackingnummer(String trackingnummer) {
        this.trackingnummer = trackingnummer;
    }
}
