package com.example.bibliotheque;

import com.example.bibliotheque.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaoSpringTests {

    @Autowired
    LivreRepository livreRepository;
    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CategorieRepository categorieRepository;

    @Test
    void testRepositoryLivre() {
        Livre livre = new Livre("Java pour les Nuls", 2022);
        livreRepository.save(livre);
    }

    @Test
    void testRepositoryAuteur() {
        Auteur auteur = new Auteur("Jean", "Bond");
        auteurRepository.save(auteur);
    }

    @Test
    void testLivreAvecAuteur() {
        Auteur auteur = new Auteur("Jean", "Bond");
        auteurRepository.save(auteur);
        Livre livre = new Livre("Java pour les Nuls", 2022);
        livre.setAuteur(auteur);
        livreRepository.save(livre);
    }

    @Test
    void testRepositoryCategorie() {
        Categorie cat = new Categorie("Sport");
        categorieRepository.save(cat);
    }

    @Test
    void testLivreAvecCategorie() {
        Categorie cat1 = new Categorie("Sciences");
        categorieRepository.save(cat1);
        Categorie cat2 = new Categorie("Humour");
        categorieRepository.save(cat2);

        Livre livre = new Livre("Java pour les Nuls", 2022);
        livre.addCategorie(cat1);
        livre.addCategorie(cat2);
        livreRepository.save(livre);
    }
}
