package com.example.bibliotheque;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class DateEmpruntSpringTests {

    @Autowired
    LivreRepository livreRepository;
    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    LivreService livreService;

    @Test
    void testDatesLivre() {
        Livre livre = new Livre("JUnit pour les Nuls", 2020);
        livre.setDateEmprunt(LocalDate.of(2023, 1, 5));
        livre.setDateRetour(LocalDate.of(2023, 1, 19));
        livreRepository.save(livre);
    }

    @Test
    void testSearch() {
        //List<Livre> livres = livreService.search("Fables");
        //List<Livre> livres = livreService.search("Nuls");
        List<Livre> livres = livreService.search("nuls");
        for(Livre livre : livres){
            System.out.println(livre);
        }
    }
}
