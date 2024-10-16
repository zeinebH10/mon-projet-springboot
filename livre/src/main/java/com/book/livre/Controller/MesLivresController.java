package com.book.livre.Controller;

import com.book.livre.service.MesLivresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MesLivresController {

    @Autowired
    private MesLivresService mesLivresService;
    @RequestMapping("/mesLivresdeleted/{id}")
    public String mesLivresdeleted(@PathVariable("id") Long id){
        mesLivresService.mesLivresdeletedById(id);
        return "redirect:/mes_livres";
    }
}
