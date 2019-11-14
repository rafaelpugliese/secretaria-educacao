package com.fat.pweb2.secretaria.educacao.controller;

import com.fat.pweb2.secretaria.educacao.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaRepository escolaRepository;

    @GetMapping("/")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("Escolas");
        modelAndView.addObject("escolas", this.escolaRepository.findAll());
        modelAndView.addObject("qntEscolas", this.escolaRepository.listarQuantidadeEscolas());
        return modelAndView;
    }

}
