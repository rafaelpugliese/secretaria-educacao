package com.fat.pweb2.secretaria.educacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("HomeEscola");
        return mv;
    }
}
