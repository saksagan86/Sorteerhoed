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
        //ByteArrayInputStream("1\n".getBytes());:
        // Een nieuwe ByteArrayInputStream
        // wordt gemaakt met de bytes van
        // de string "1\n". Deze string simuleert
        // de invoer van de gebruiker, alsof ze
        // '1' hebben ingevoerd en op Enter hebben gedrukt.
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        //  De standaard invoer (System.in) wordt vervangen door de eerder gemaakte inputStream.
        // Dit zorgt ervoor dat wanneer toonMenu() om
        // invoer vraagt, het de gesimuleerde invoer ("1\n") zal ontvangen.
        //---sys.in
        System.setIn(inputStream);
        //ByteArrayOutputStream wordt gemaakt om de
        // uitvoer van de toonMenu() methode op te vangen.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // De standaard uitvoer (System.out) wordt vervangen door
        // een nieuwe PrintStream die is verbonden met de eerder
        // gemaakte outputStream. Dit zorgt ervoor dat alle uitvoer
        // van toonMenu() naar outputStream wordt geschreven in plaats
        // van naar de standaard console.
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
