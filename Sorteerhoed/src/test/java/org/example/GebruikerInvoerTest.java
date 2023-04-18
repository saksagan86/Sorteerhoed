package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GebruikerInvoerTest {

    @Test
    public void testToonMenu() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GebruikerInvoer gebruikerInvoer = new GebruikerInvoer();
        int keuze = gebruikerInvoer.toonMenu();
        assertEquals(1, keuze);
    }

    @Test
    public void testKiesKlant() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GebruikerInvoer gebruikerInvoer = new GebruikerInvoer();
        ArrayList<Klant> klanten = new ArrayList<>();
        Adres adres = new AdresNederland("Teststraat", "1", "1234 AB", "Teststad");
        Klant klant = new Klant(adres, "Test Naam", "test@email.com", "0123456789");
        klanten.add(klant);

        Klant gekozenKlant = gebruikerInvoer.kiesKlant(klanten);
        assertEquals(klant, gekozenKlant);
    }
}
