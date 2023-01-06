package com.example.bibliotheque.business;

import com.example.bibliotheque.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    LivreRepository livreRepository;

    public void createAuteur(Auteur auteur){
        auteurRepository.save(auteur);
    }
    public void createCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }
    public void createLivre(Livre livre){
        livreRepository.save(livre);
    }
    public List<Livre> getLivres(){
        return livreRepository.findAll();
    }
}
