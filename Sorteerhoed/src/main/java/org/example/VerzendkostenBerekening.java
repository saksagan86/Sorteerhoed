package org.example;

public class VerzendkostenBerekening {

    public double berekenVerzendkosten(double gewicht, int bestemming, boolean verzekering, boolean spoedverzending) {
        double verzendkosten = gewicht * 0.01;
        if (bestemming == 2) {
            verzendkosten *= 1.5; // Verhoog de verzendkosten met 50% voor internationale zendingen
        }
        if (verzekering) {
            verzendkosten += 5; // Voeg 5 euro toe voor verzekering
        }
        if (spoedverzending) {
            verzendkosten *= 1.25; // Verhoog de verzendkosten met 25% voor spoedverzending
        }

        return verzendkosten;
    }

}
