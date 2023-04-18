package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GebruikerInvoer {
    private Scanner input;


    public GebruikerInvoer() {
        this.input = new Scanner(System.in);
    }
    public Scanner getInput() {
        return input;
    }
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

    public Klant verzamelKlantgegevens() {
        String naam = getValidInput("Voer uw naam in: ");
        String email = getValidInput("Voer uw e-mailadres in: ");
        String telefoonnummer = getValidInput("Voer uw telefoonnummer in: ");

        Adres adres = verzamelAdresgegevens();
        return new Klant(adres, naam, email, telefoonnummer);
    }

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


    public boolean getVerzekering() {
        System.out.println("Wilt u een verzekering toevoegen? (ja/nee)");
        String verzekering = input.next();
        return verzekering.equalsIgnoreCase("ja");
    }

    public boolean getSpoedverzending() {
        System.out.println("Wilt u spoedverzending toevoegen? (ja/nee)");
        String spoedverzending = input.next();
        return spoedverzending.equalsIgnoreCase("ja");
    }
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
