package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GebruikerInvoer {
    private Scanner input;


    public GebruikerInvoer() {
        this.input = new Scanner(System.in);
    }

    // Deze methode toont het hoofdmenu en retourneert
    // de keuze van de gebruiker als een geheel getal.
    public int toonMenu() {
        Scanner scanner = new Scanner(System.in);
        int keuze;

        while (true) {
            System.out.println("\nKies een optie:");
            System.out.println("1 - Voer nieuwe klant in");
            System.out.println("2 - Maak verzendetiket klant");
            System.out.println("3 - Bereken verzendkosten");
            System.out.println("4 - Toon klantenlijst");
            System.out.println("5 - Afsluiten");

            String invoer = scanner.nextLine();
            try {
                keuze = Integer.parseInt(invoer);

                if (keuze < 1 || keuze > 5) {
                    System.out.println("Ongeldige invoer, probeer opnieuw!");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer, probeer opnieuw!");
            }
        }
        return keuze;
    }
    // Deze methode laat de gebruiker een klant uit de gegeven
    // klantenlijst kiezen en retourneert het gekozen Klant object.

    public Klant kiesKlant(ArrayList<Klant> klanten) {
        if (klanten.isEmpty()) {
            System.out.println("Er zijn geen klanten in de lijst. Voeg eerst een klant toe.");
            return null;
        }

        int klantIndex = -1;
        while (klantIndex < 0 || klantIndex >= klanten.size()) {
            System.out.println("Kies een klant uit de lijst:");
            for (int i = 0; i < klanten.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, klanten.get(i).getNaam());
            }

            String invoer = input.nextLine();
            try {
                klantIndex = Integer.parseInt(invoer) - 1;
                if (klantIndex < 0 || klantIndex >= klanten.size()) {
                    System.out.println("Ongeldige keuze. Probeer het opnieuw.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer, probeer opnieuw!\n");
            }
        }

        return klanten.get(klantIndex);
    }

    // Deze methode verzamelt de gegevens van een
    // nieuwe klant en retourneert een nieuw Klant object.
    public Klant verzamelKlantgegevens() {
        String naam = getValidInput("Voer uw naam in: ");
        String email = getValidInput("Voer uw e-mailadres in: ");
        String telefoonnummer = getValidInput("Voer uw telefoonnummer in: ");

        Adres adres = verzamelAdresgegevens();
        return new Klant(adres, naam, email, telefoonnummer);
    }

    // Deze methode vraagt om een geldige invoer
    // van de gebruiker en retourneert de ingevoerde tekst.
    public String getValidInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = this.input.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Dit veld mag niet leeg zijn!");
            }
        } while (input.trim().isEmpty());
        return input;
    }
    // Deze methode vraagt om een adreskeuze en
    // retourneert de gekozen optie als een geheel getal.
    public int getAdresKeuze() {
        int keuze;
        while (true) {
            System.out.println("Voor waar is de pakket bestemd?");
            System.out.println("1-Nederland");
            System.out.println("2-Buitenland");

            try {
                keuze = Integer.parseInt(input.nextLine());
                if (keuze == 1 || keuze == 2) {
                    return keuze;
                } else {
                    System.out.println("Ongeldige invoer. Probeer het opnieuw.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer, probeer opnieuw!");
            }
        }
    }

    // Deze methode verzamelt adresgegevens
    // en retourneert een nieuw Adres object.
    public Adres verzamelAdresgegevens() {
        int keuze = getAdresKeuze();

        String straat = getValidInput("Voer straat in: ");
        String huisnummer = getValidInput("Voer huisnummer in: ");
        String postcode = getValidInput("Voer postcode in: ");
        String stad = getValidInput("Voer stad in: ");

        Adres adres = null;
        if (keuze == 1) {
            adres = new AdresNederland(straat, huisnummer, postcode, stad);
        } else if (keuze == 2) {
            String land = getValidInput("Voer land in: ");
            adres = new AdresBuitenland(straat, huisnummer, postcode, stad, land);
        }

        System.out.println("Het ingevoerde adres is:");
        System.out.println(adres.getAdres());
        return adres;
    }
    // Deze methode vraagt om het gewicht van een pakket
    // en retourneert het ingevoerde gewicht als een double.

    public double getGewicht() {
        double gewicht;
        do {
            System.out.println("Voer het gewicht van het pakket in grammen in:");
            gewicht = input.nextDouble();
            input.nextLine();

            if (gewicht <= 0) {
                System.out.println("Ongeldige invoer. Probeer het opnieuw.");
            }
        } while (gewicht <= 0);

        return gewicht;
    }

    // Deze methode vraagt om de bestemming van een pakket
    // en retourneert de gekozen optie als een geheel getal.

    public int getBestemming() {
        int bestemming;
        while(true){
            System.out.println("Kies de bestemming van uw pakket: \n1.Nationaal\n2.Internationaal");
            try{
                bestemming = Integer.parseInt(input.nextLine());
                if(bestemming ==1 || bestemming ==2){
                    return bestemming;
                }
                else{
                    System.out.println("Ongeldige invoer. Probeer het opnieuw");
                }
            }catch (NumberFormatException e){
                System.out.println("Ongeldige invoer. Probeer het opnieuw");
            }
        }
    }

    // Deze methode vraagt of de gebruiker een verzekering wil toevoegen
    // en retourneert een boolean waarde.
    public boolean getVerzekering() {
        System.out.println("Wilt u een verzekering toevoegen? (ja/nee)");
        String verzekering = input.next();
        return verzekering.equalsIgnoreCase("ja");
    }

    // Deze methode vraagt of de gebruiker een spoed verzekering wil toevoegen
    // en retourneert een boolean waarde.
    public boolean getSpoedverzending() {
        System.out.println("Wilt u spoedverzending toevoegen? (ja/nee)");
        String spoedverzending = input.next();
        return spoedverzending.equalsIgnoreCase("ja");
    }

    // Deze methode berekent de verzendkosten op basis van de ingevoerde
    // gegevens en retourneert de berekende kosten als een double.
    public double berekenVerzendkosten() {
        double gewicht = getGewicht();
        int bestemming = getBestemming();
        boolean verzekering = getVerzekering();
        boolean spoedverzending = getSpoedverzending();

        VerzendkostenBerekening verzendkostenBerekening = new VerzendkostenBerekening();
        double verzendkosten = verzendkostenBerekening.berekenVerzendkosten(gewicht, bestemming, verzekering, spoedverzending);

        return verzendkosten;
    }
}
