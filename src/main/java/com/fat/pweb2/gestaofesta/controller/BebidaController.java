package com.fat.pweb2.gestaofesta.controller;

import com.fat.pweb2.gestaofesta.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaRepository bebidas;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaBebidas");
        mv.addObject("listaBebidas", this.bebidas.findAll());

        return mv;
    }

}
