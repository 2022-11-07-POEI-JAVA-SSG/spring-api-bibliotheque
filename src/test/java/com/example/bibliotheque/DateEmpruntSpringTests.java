package com.example.bibliotheque;

import com.example.bibliotheque.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class DateEmpruntSpringTests {

    @Autowired
    LivreRepository livreRepository;
    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CategorieRepository categorieRepository;

    @Test
    void testDatesLivre() {
        Livre livre = new Livre("JUnit pour les Nuls", 2020);
        livre.setDateEmprunt(LocalDate.of(2023, 1, 5));
        livre.setDateRetour(LocalDate.of(2023, 1, 19));
        livreRepository.save(livre);
    }

}
