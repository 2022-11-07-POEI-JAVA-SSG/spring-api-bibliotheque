package com.example.bibliotheque;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.Livre;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class DateEmpruntUnitTests {

    @Test
    void emprunt1(){
        Livre livre = new Livre("JUnit pour les Nuls", 2020);
        livre.setDateEmprunt(LocalDate.of(2023, 1, 5));
        livre.setDateRetour(LocalDate.of(2023, 1, 19));


        LivreService livreService = new LivreService();
        boolean estDispo = livreService.estDisponiblePourEmprunt(livre);
        assertFalse(estDispo);
    }

    @Test
    void emprunt2(){
        Livre livre = new Livre("JUnit pour les Nuls", 2020);

        LivreService livreService = new LivreService();
        boolean estDispo = livreService.estDisponiblePourEmprunt(livre);
        assertTrue(estDispo);
    }

    @Test
    void emprunt3(){
        Livre livre = new Livre("JUnit pour les Nuls", 2020);
        livre.setDateRetour(LocalDate.of(2023, 1, 2));

        LivreService livreService = new LivreService();
        boolean estDispo = livreService.estDisponiblePourEmprunt(livre);
        assertTrue(estDispo);
    }
}
