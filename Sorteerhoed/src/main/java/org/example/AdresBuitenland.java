package org.example;

public class AdresBuitenland extends Adres {
    private String land;

    public AdresBuitenland(String straat, String huisnummer, String postcode, String stad, String land) {
        super(straat, huisnummer, postcode, stad);
        this.land = land;
    }

    @Override
    public String getAdres() {
        return super.getAdres() + ", " + getLand();
    }

    @Override
    public String getLand() {
        return land;
    }
}
