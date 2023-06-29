package org.example;
public abstract class Adres {
    protected String straat;
    protected String huisnummer;
    protected String postcode;
    protected String stad;

    public Adres(String straat, String huisnummer, String postcode, String stad) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.stad = stad;
    }

    public String getAdres() {
        return straat + " " + huisnummer + ", " + postcode + " " + stad;
    }
    public String getPostcode() {
        return postcode;
    }

    public String getStad() {
        return stad;
    }

    public abstract String getLand();
}