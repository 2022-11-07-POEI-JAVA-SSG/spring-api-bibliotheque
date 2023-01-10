package com.example.bibliotheque.mvc;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.Auteur;
import com.example.bibliotheque.dao.Categorie;
import com.example.bibliotheque.dao.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminBibliothequeMvcController {

    @Autowired
    LivreService livreService;

    @GetMapping("admin")
    public ModelAndView admin(){

        ModelAndView view = new ModelAndView("admin-bibli.html");

        List<Auteur> auteurs = livreService.getAuteurs();
        view.addObject("auteurs", auteurs);

        List<Categorie> categories = livreService.getCategories();
        view.addObject("categories", categories);

        return view;
    }

    @PostMapping("categories")
    public ModelAndView createCategorie(Categorie categorie) {
        livreService.createCategorie(categorie);

        ModelAndView view = new ModelAndView("livres.html");
        view.addObject("livres", livreService.getLivres());

        return view;
    }

    @PostMapping("auteurs")
    public ModelAndView createCategorie(Auteur auteur) {
        livreService.createAuteur(auteur);

        ModelAndView view = new ModelAndView("livres.html");
        view.addObject("livres", livreService.getLivres());

        return view;
    }
/*    @PostMapping("auteurs")
    public ModelAndView createCategorie(String prenom, String nom) {
        livreService.createAuteur(new Auteur(prenom, nom));

        ModelAndView view = new ModelAndView("livres.html");
        view.addObject("livres", livreService.getLivres());

        return view;
    }*/

    @PostMapping("livres")
    public ModelAndView createLivre(Livre livre){
        System.out.println(livre);

        livreService.createLivre(livre);

        ModelAndView view = new ModelAndView("livres.html");
        view.addObject("livres", livreService.getLivres());
        return view;
    }
}
