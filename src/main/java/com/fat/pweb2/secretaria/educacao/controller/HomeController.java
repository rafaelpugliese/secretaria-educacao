package com.fat.pweb2.secretaria.educacao.controller;

import com.fat.pweb2.secretaria.educacao.model.Escola;
import com.fat.pweb2.secretaria.educacao.repository.EscolaRepository;
import com.fat.pweb2.secretaria.educacao.repository.projection.NomeEscolaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.fat.pweb2.secretaria.educacao.util.SessaoUtil.obterLoginUsuario;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private EscolaRepository escolaRepository;

    @GetMapping("/home")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("HomeEscola");
        String nomeUsuario = obterLoginUsuario();
        mv.addObject("nomUsuarioLogado", nomeUsuario);

        List<NomeEscolaProjection> escola = escolaRepository.findByNomeIs("Marista");

        return mv;
    }
}
