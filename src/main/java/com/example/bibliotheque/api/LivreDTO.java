package com.example.bibliotheque.api;

import com.example.bibliotheque.dao.Auteur;
import com.example.bibliotheque.dao.Categorie;
import com.example.bibliotheque.dao.Livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;


public class LivreDTO {

    private Integer id;

    private String titre;
    private int annee;

    private String resume;

    private LocalDate dateEmprunt;

    private LocalDate dateRetour;


    private Auteur auteur;


    private List<Categorie> categories = new ArrayList<>();


    private int nombreJourAttente;




    public LivreDTO() {
    }

    public LivreDTO(String titre, int annee) {
        this.titre = titre;
        this.annee = annee;
    }

    public LivreDTO(Livre entity) {

        this.id = entity.getId();
        this.titre = entity.getTitre();
        this.annee = entity.getAnnee();
        this.resume = entity.getResume();
        this.dateEmprunt = entity.getDateEmprunt();
        this.dateRetour = entity.getDateRetour();
        this.auteur = entity.getAuteur();
        this.categories = entity.getCategories();


        LocalDate jour = LocalDate.now();
        LocalDate dateRetour = entity.getDateRetour();
        if(dateRetour == null || dateRetour.isBefore(jour)) {
            this.nombreJourAttente = 0;
        } else {
            this.nombreJourAttente = (int)ChronoUnit.DAYS.between(jour, dateRetour);
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public void addCategorie(Categorie cat){
        categories.add(cat);
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getNombreJourAttente() {
        return nombreJourAttente;
    }

    public void setNombreJourAttente(int nombreJourAttente) {
        this.nombreJourAttente = nombreJourAttente;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                '}';
    }

}
