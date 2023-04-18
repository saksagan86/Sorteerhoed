package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private GebruikerInvoer gebruikerInvoer;
    private ArrayList<Klant> klanten;

    public Menu(GebruikerInvoer gebruikerInvoer) {
        this.gebruikerInvoer = gebruikerInvoer;
        this.klanten = new ArrayList<>();
    }

    public void start() {
        int menuOptie;
        do {
            menuOptie = gebruikerInvoer.toonMenu();;
            if (menuOptie == 1) {
                Klant klant = gebruikerInvoer.verzamelKlantgegevens();
                klanten.add(klant);
            }
            if (menuOptie == 2) {
                Klant klant = gebruikerInvoer.kiesKlant(klanten);
                if (klant != null) {
                    VerzendEtiket etiket = new VerzendEtiket(klant.getAdres());
                    System.out.println("\nHet gegenereerde verzendetiket is:");
                    System.out.println(etiket.genereerEtiket());
                }
            }

            if (menuOptie == 3) {
                double verzendkosten = gebruikerInvoer.berekenVerzendkosten();
                System.out.printf("De verzendkosten zijn: €%.2f\n", verzendkosten);

            }
            if (menuOptie == 4) {
                toonKlantenlijst();

            }

        } while (menuOptie != 5);
        System.out.println("Bedankt voor het gebruiken van onze applicatie!");
    }



    private void toonKlantenlijst() {
        if (klanten.isEmpty()) {
            System.out.println("Er zijn geen klanten in de lijst.");
            return;
        }

        System.out.println("\n======Klantenlijst======");
        for (Klant klant : klanten) {
            System.out.println("Klantnummer: #" + klant.getKlantnummer());
            System.out.println("Naam: " + klant.getNaam());
            System.out.println("E-mail: " + klant.getEmail());
            System.out.println("Telefoonnummer: " + klant.getTelefoonnummer());
            System.out.println("Adres: " + klant.getAdres().getAdres());
            System.out.println("-------------------------------");
        }
    }

}




/*
        if (keuze == 1) {
        Klant klant = gebruikerInvoer.verzamelKlantgegevens();
        klanten.add(klant);
    } else if (keuze == 2) {
        Klant klant = kiesKlant();
        if (klant != null) {
            VerzendEtiket etiket = new VerzendEtiket(klant.getAdres());
            System.out.println("\nHet gegenereerde verzendetiket is:");
            System.out.println(etiket.genereerEtiket());
        }
    } else if (keuze == 3) {
        double verzendkosten = gebruikerInvoer.berekenVerzendkosten();
        System.out.printf("De verzendkosten zijn: €%.2f\n", verzendkosten);
    } else if (keuze == 4) {
        toonKlantenlijst();
    } else if (keuze == 5) {
        System.out.println("Bedankt voor het gebruiken van onze applicatie. Tot ziens!");
    } else {
        System.out.println("Ongeldige invoer. Probeer het opnieuw.");
    }
}
    }*/
