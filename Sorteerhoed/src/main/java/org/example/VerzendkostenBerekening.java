package org.example;

public class VerzendkostenBerekening {

    public double berekenVerzendkosten(double gewicht, boolean verzekering) {
        double verzendkosten;
        if (verzekering) {
            verzendkosten = (gewicht * 0.01)+5;
        }
        else if (gewicht >= 1000 && gewicht <= 5000) {
            verzendkosten = gewicht * 0.01;
        }
        else {
            verzendkosten = (gewicht * 0.01) + gewicht/1000;
        }

        return verzendkosten;
    }

}
