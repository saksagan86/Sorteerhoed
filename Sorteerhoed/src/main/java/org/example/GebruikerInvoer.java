package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GebruikerInvoer {
    private Scanner input;

    public GebruikerInvoer() {
        this.input = new Scanner(System.in);
    }

    public int toonMenu() {
        ToonMenu toonMenu = new ToonMenu();
        toonMenu.execute();
        return toonMenu.getKeuze();
    }

    public Klant kiesKlant(ArrayList<Klant> klanten) {
        if (klanten.isEmpty()) {
            System.out.println("Er zijn geen klanten in de lijst. Voeg eerst een klant toe.");
            return null;
        }
        return selecteerKlantUitLijst(klanten);
    }

    private Klant selecteerKlantUitLijst(ArrayList<Klant> klanten){
        int klantIndex = -1;
        while (klantIndex < 0 || klantIndex >= klanten.size()) {
            klantIndex = vraagKlantKeuze(klanten);
        }
        return klanten.get(klantIndex);
    }

    private int vraagKlantKeuze(ArrayList<Klant> klanten){
        System.out.println("Kies een klant uit de lijst:");
        toonKlantLijst(klanten);
        String invoer = input.nextLine();
        try {
            int klantIndex = Integer.parseInt(invoer) - 1;
            if (klantIndex < 0 || klantIndex >= klanten.size()) {
                System.out.println("Ongeldige keuze. Probeer het opnieuw.\n");
            }
            return klantIndex;
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer, probeer opnieuw!\n");
        }
        return -1;
    }

    private void toonKlantLijst(ArrayList<Klant> klanten){
        for (int i = 0; i < klanten.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, klanten.get(i).getNaam());
        }
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

        AdresFactory adresFactory;
        String land = null;
        if (keuze == 1) {
            adresFactory = new AdresNederlandFactory();
        } else if (keuze == 2) {
            land = getValidInput("Voer land in: ");
            adresFactory = new AdresBuitenlandFactory();
        } else {
            return null;
        }

        Adres adres = adresFactory.createAdres(straat, huisnummer, postcode, stad, land);

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
    public boolean getVerzekering() {
        System.out.println("Wilt u een verzekering toevoegen? (ja/nee)");
        String verzekering = input.next();
        return verzekering.equalsIgnoreCase("ja");
    }

    public double berekenVerzendkosten() {
        double gewicht = getGewicht();

        boolean verzekering = getVerzekering();


        VerzendkostenBerekening verzendkostenBerekening = new VerzendkostenBerekening();
        double verzendkosten = verzendkostenBerekening.berekenVerzendkosten(gewicht, verzekering);

        return verzendkosten;
    }
}

//int i = 0;: The loop counter i is initialized to 0.
// This represents the starting index of the klanten list,
// which is an ArrayList of Klant objects.

//i < klanten.size();: The loop will continue as long as
// i is less than the size of the klanten list.
// This ensures that every customer in the list is considered during the iteration.


//2    //subtracts 1 to obtain the actual index in the klanten list: