package com.example.bibliotheque.business;

import com.example.bibliotheque.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public boolean estDisponiblePourEmprunt(Livre livre){
        LocalDate jour = LocalDate.now();

        LocalDate dateRetour = livre.getDateRetour();

        if(dateRetour == null || dateRetour.isBefore(jour)) {
            return true;
        } else {
            return false;
        }
    }

    public Livre getLivre(Integer id){
        return livreRepository.findById(id).get();
    }
}
