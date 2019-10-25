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
import javax.validation.constraints.Null;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository convidados;

    @Autowired
    private BebidaRepository bebidas;

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaConvidados");
        mv.addObject("convidados", convidados.findAll());

        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionar(){
        ModelAndView mv = new ModelAndView("AdicionaConvidado");
        mv.addObject(new Convidado());
        mv.addObject("listaBebidas", this.bebidas.findAll());

        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(@Valid Convidado convidado,
                                  BindingResult result,
                                  RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView();

        if(result.hasErrors()){
            mv.setViewName("AdicionaConvidado");
            mv.addObject("listaBebidas", this.bebidas.findAll());
            return mv;
        }

        mv.setViewName("redirect:/convidados/listar");

        if(convidado.getId() != null){
            attributes.addFlashAttribute("mensagem", "Convidado editado com sucesso.");
        } else {
            attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso.");
        }

        this.convidados.save(convidado);

        return mv;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,
                                RedirectAttributes attributes){
        this.convidados.deleteById(id);
        ModelAndView mv = new ModelAndView("redirect:/convidados/listar");
        attributes.addFlashAttribute("mensagem", "Convidado removido com sucesso.");

        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("AdicionaConvidado");
        mv.addObject("convidado", this.convidados.findById(id));
        mv.addObject("id", id);
        mv.addObject("listaBebidas", this.bebidas.findAll());

        return mv;
    }
}
