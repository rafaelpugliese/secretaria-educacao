package com.fat.pweb2.gestaofesta.controller;

import com.fat.pweb2.gestaofesta.model.Convidado;
import com.fat.pweb2.gestaofesta.repository.BebidaRepository;
import com.fat.pweb2.gestaofesta.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaRepository bebidas;

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaBebidas");
        mv.addObject("listaBebidas", this.bebidas.findAll());

        return mv;
    }

}
