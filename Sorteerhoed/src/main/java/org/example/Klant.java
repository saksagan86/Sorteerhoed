package org.example;

public class Klant {
    private Adres adres;
    private String naam;
    private String email;
    private String telefoonnummer;
    private int klantnummer;
    //voor elke object die aangemaakt gaat 1 omhoog
    //verboonden aan class
    private static int klantTeller = 0;
    public Klant(Adres adres, String naam, String email, String telefoonnummer) {
        this.adres = adres;
        this.naam = naam;
        this.email = email;
        this.telefoonnummer =telefoonnummer;
        klantTeller++;
        this.klantnummer = klantTeller;
    }
    public Adres getAdres() {return adres;}
    public void setAdres(Adres adres) {this.adres = adres;}
    public String getNaam() {return naam;}
    public void setNaam(String naam) {this.naam = naam;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {this.email = email;}
    public String getTelefoonnummer() {
        return telefoonnummer;
    }
    public void setTelefoonnummer(String telefoonnummer) {this.telefoonnummer = telefoonnummer;}
    public int getKlantnummer() {return klantnummer;
    }
}
