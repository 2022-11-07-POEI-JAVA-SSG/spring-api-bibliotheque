package com.example.bibliotheque.mvc;

import com.example.bibliotheque.business.LivreService;
import com.example.bibliotheque.dao.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BibliothequeMvcController {

    @Autowired
    LivreService livreService;

    @GetMapping("livres")
    public ModelAndView getLivres(){

        ModelAndView view = new ModelAndView("livres.html");

        List<Livre> livres = livreService.getLivres();
        view.addObject("livres", livres);

        return view;
    }

    @GetMapping("fichelivre")
    public ModelAndView getLivres(@RequestParam Integer id){

        ModelAndView view = new ModelAndView("livre-details.html");

        Livre livre = livreService.getLivre(id);
        view.addObject("livre", livre);

        return view;
    }
}
