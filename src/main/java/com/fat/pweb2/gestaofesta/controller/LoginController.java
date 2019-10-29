package com.fat.pweb2.gestaofesta.controller;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    // Realiza o mapeamento de "/" e "/loginfat" para este método
    @GetMapping(value = {"/", "/loginfat"})
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("Logingestao");
        return mv;
    }

    @GetMapping("/errologin")
    public ModelAndView errologin(HttpServletRequest request, Model model) {
        ModelAndView mv = login();

        // Obtem a sessão atual
        HttpSession session = request.getSession(false);

        String mensagemErro = null;

        if (session != null) {
            // Obtem atributo WebAttributes.AUTHENTICATION_EXCEPTION da sessão
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                // Obtem o erro existente na sessão
                mensagemErro = ex.getMessage();
            }
        }
        // Preenche a variável errorMessage com o erro existente
        mv.addObject("mensagemErro", mensagemErro);

        return mv;
    }
}
