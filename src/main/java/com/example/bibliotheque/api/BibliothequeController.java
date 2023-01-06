package com.example.bibliotheque.api;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.Auteur;
import com.example.bibliotheque.dao.Categorie;
import com.example.bibliotheque.dao.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<LivreDTO> getLivres(){
        List<Livre> livres = livreService.getLivres();
        List<LivreDTO> dtos = new ArrayList<>();
        for(Livre entity : livres){
            dtos.add(new LivreDTO(entity));
        }
        return dtos;
    }

    @GetMapping("estDispo")
    public Boolean estDispo(@RequestParam Integer livreId){
        Livre livre = livreService.getLivre(livreId);
        return livreService.estDisponiblePourEmprunt(livre);
    }

    @GetMapping("recherche")
    public List<Livre> recherche(@RequestParam String searchKeyword){
        return livreService.search(searchKeyword);
    }
}
