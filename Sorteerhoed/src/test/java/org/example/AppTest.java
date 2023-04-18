package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {


    @Test
    public void testGenererenVerzendEtiket() {
        Adres adres = new AdresNederland("Dorpstraat", "12", "1234 AB", "Amsterdam");
        VerzendEtiket etiket = new VerzendEtiket(adres);
        String expectedEtiket = "Verzendadres:\n" + "Dorpstraat 12, 1234 AB Amsterdam, Nederland" + "\n";
        String actualEtiket = etiket.genereerEtiket();
        assertEquals(expectedEtiket, actualEtiket);
    }

}
