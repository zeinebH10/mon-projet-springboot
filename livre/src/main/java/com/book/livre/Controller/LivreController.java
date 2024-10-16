package com.book.livre.Controller;

import com.book.livre.entity.Livre;
import com.book.livre.entity.MesLivres;
import com.book.livre.service.LivreService;
import com.book.livre.service.MesLivresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;
    @Autowired
    public MesLivresService mls;

  //  @GetMapping("/") public String home(){ return "index";}

    @GetMapping("/nouveau_livre")
    public String nouveauLivre(){
        return "nouveauLivre";
    }

    @GetMapping("livres_disponibles")
    public ModelAndView livresDisponibles(){
        ModelAndView mav = new ModelAndView();
        List<Livre> listes = livreService.livresDisponibles();
        mav.setViewName("listeLivre");
        mav.addObject("livre", "listes");
        return new ModelAndView("listeLivre", "livre", listes);
    }

    @GetMapping("/mes_livres")
    public String mesLivres(Model model){
        List<MesLivres> laListeDeMesLivres = mls.listeDeMeslivres();
        model.addAttribute("mesLivres", laListeDeMesLivres);
        return "mesLivres";
    }

    @PostMapping("/save")
    public String AjouterLivre(@ModelAttribute Livre livre){
        livreService.save(livre);
        return "redirect:/livres_disponibles";
    }

    @RequestMapping("/mesLivres/{id}")
    public String obtenirMesLivres(@PathVariable("id") Long id){
        Livre l = livreService.obtenirParId(id);
        MesLivres ml = new MesLivres(l.getId(), l.getTitle(), l.getAuteur(), l.getEdition(), l.getNbPage(), l.getPrix(), l.getImage());
        mls.ajouterMesLivres(ml);
        return "redirect:/mes_livres";

    }

    @RequestMapping("modifier_livre/{id}")
    public String modifier(@PathVariable("id") Long id, Model model){
        Livre livreModif = livreService.obtenirParId(id);
        model.addAttribute("livre", livreModif);
        return "modifierLivre";
    }

    @RequestMapping("/delete_livre/{id}")
    public String deletedLivre(@PathVariable("id") Long id){
        Livre livre = livreService.obtenirParId(id);
        livreService.livreEffacer(livre);
        return "redirect:/livres_disponibles";
    }
    @GetMapping("/")
    public String home(Model model){
        List<Livre> listes = livreService.livresDisponibles();
        model.addAttribute("livres", listes);
        return "index";
    }



}
