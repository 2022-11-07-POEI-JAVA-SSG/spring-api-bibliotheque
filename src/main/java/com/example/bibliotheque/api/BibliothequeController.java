package com.example.bibliotheque.api;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.Auteur;
import com.example.bibliotheque.dao.Categorie;
import com.example.bibliotheque.dao.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BibliothequeController {

    @Autowired
    LivreService livreService;

    @PostMapping("auteurs")
    public void createAuteur(@RequestBody Auteur auteur){
        livreService.createAuteur(auteur);
    }

    @PostMapping("categories")
    public void createCategorie(@RequestBody Categorie categorie){
        livreService.createCategorie(categorie);
    }

    @PostMapping("livres")
    public void createLivre(@RequestBody Livre livre){
        livreService.createLivre(livre);
    }

    @GetMapping("livres")
    public List<Livre> getLivres(){
        return livreService.getLivres();
    }

    @GetMapping("estDispo")
    public Boolean estDispo(@RequestParam Integer livreId){
        Livre livre = livreService.getLivre(livreId);
        return livreService.estDisponiblePourEmprunt(livre);
    }
}
