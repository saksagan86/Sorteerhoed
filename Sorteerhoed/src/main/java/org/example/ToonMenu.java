package org.example;

import java.util.Scanner;

public class ToonMenu extends UserInteractionTemplate {
    private Scanner scanner = new Scanner(System.in);
    private int keuze;

    @Override
    protected void printMessage() {
        System.out.println("\nKies een optie:");
        System.out.println("1 - Voer nieuwe klant in");
        System.out.println("2 - Maak verzendetiket klant");
        System.out.println("3 - Bereken verzendkosten");
        System.out.println("4 - Toon klantenlijst");
        System.out.println("5 - Afsluiten");
    }

    @Override
    protected String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    protected boolean validateInput(String input) {
        try {
            keuze = Integer.parseInt(input);
            return (keuze >= 1 && keuze <= 5);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void printErrorMessage() {
        System.out.println("Ongeldige invoer, probeer opnieuw!");
    }

    @Override
    protected void performAction() {
        // You can implement the action here
    }

    public int getKeuze() {
        return keuze;
    }
}