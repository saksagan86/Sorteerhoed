package org.example;

public class Main {
    public static void main(String[] args) {
        GebruikerInvoer gebruikerInvoer = new GebruikerInvoer();
        Menu menu = new Menu(gebruikerInvoer);
        menu.start();
    }
}