package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class VerzendkostenBerekeningTest {
    VerzendkostenBerekening berekening = new VerzendkostenBerekening();


    @Test
    public void testBerekenVerzendkosten_MetVerzekering() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();
        double gewicht = 2000;
        boolean verzekering = true;

        // Act
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(gewicht, verzekering);

        // Assert
        double verwachteVerzendkosten = (gewicht * 0.01) + 5;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtTussen1000En5000() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();
        double gewicht = 3000;
        boolean verzekering = false;

        // Act
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(gewicht, verzekering);

        // Assert
        double verwachteVerzendkosten = gewicht * 0.01;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtBoven5000() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();
        double gewicht = 6000;
        boolean verzekering = false;

        // Act
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(gewicht, verzekering);

        // Assert
        double verwachteVerzendkosten = (gewicht * 0.01) + gewicht/1000;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtLager1000() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();
        double gewicht = 999;
        boolean verzekering = false;

        // Act
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(gewicht, verzekering);

        // Assert
        double verwachteVerzendkosten = (gewicht * 0.01) + gewicht/1000;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten);
    }

    @Test
    public void testVerzekerdeVerzending() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();

        // Act
        double resultaat = berekening.berekenVerzendkosten(2000, true);

        // Assert
        assertEquals(25, resultaat);
    }

    @Test
    public void testOnverzekerdeVerzendingBinnenGewichtsbeperking() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();

        // Act
        double resultaatMin = berekening.berekenVerzendkosten(1000, false);
        double resultaatMax = berekening.berekenVerzendkosten(5000, false);

        // Assert
        assertEquals(10, resultaatMin);
        assertEquals(50, resultaatMax);
    }

    @Test
    public void testOnverzekerdeVerzendingBuitenGewichtsbeperking() {
        // Arrange
        VerzendkostenBerekening berekening = new VerzendkostenBerekening();

        // Act
        double resultaatMin = berekening.berekenVerzendkosten(999, false);
        double resultaatMax = berekening.berekenVerzendkosten(5001, false);

        // Assert
        assertEquals(10.99, resultaatMin, 0.01);
        assertEquals(55.01, resultaatMax, 0.01);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtMinderDan1000_MetVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(999, true);
        double verwachteVerzendkosten = (999 * 0.01) + 5;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtMinderDan1000_ZonderVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(999, false);
        double verwachteVerzendkosten = (999 * 0.01) + 999.0/1000;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtTussen1000En5000_ZonderVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(3000, false);
        double verwachteVerzendkosten = 3000 * 0.01;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtTussen1000En5000_MetVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(3000, true);
        double verwachteVerzendkosten = (3000 * 0.01) + 5;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtMeerDan5000_MetVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(6000, true);
        double verwachteVerzendkosten = (6000 * 0.01) + 5;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }

    @Test
    public void testBerekenVerzendkosten_GewichtMeerDan5000_ZonderVerzekering() {
        double daadwerkelijkeVerzendkosten = berekening.berekenVerzendkosten(6000, false);
        double verwachteVerzendkosten = (6000 * 0.01) + 6000/1000;
        assertEquals(verwachteVerzendkosten, daadwerkelijkeVerzendkosten, 0.001);
    }



}